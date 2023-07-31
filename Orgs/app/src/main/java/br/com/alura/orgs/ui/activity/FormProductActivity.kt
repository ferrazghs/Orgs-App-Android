package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.databinding.ActivityFormProductBinding
import br.com.alura.orgs.ui.dao.ProductDao
import br.com.alura.orgs.ui.dialog.FormImageDialog
import br.com.alura.orgs.ui.extension.loadImage
import br.com.alura.orgs.ui.model.Produtc
import coil.load
import java.math.BigDecimal

class FormProductActivity :
    AppCompatActivity() {

    private var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFormProductBinding.inflate(layoutInflater)

        setContentView(binding.root)
        configButtonSave(binding)

        binding.imageFormProduct.setOnClickListener {
            FormImageDialog(this).loadImageDialog(url) { image ->
                url = image
                binding.imageFormProduct.loadImage(url)
            }
        }
    }

    private fun configButtonSave(binding: ActivityFormProductBinding) {
        val buttonSave = binding.activityFormProductButtonSave
        val fieldName = binding.activityFormProductTitle
        val fieldDesc = binding.activityFormProductDescription
        val fieldPrice = binding.activityFormProductPrice

        buttonSave.setOnClickListener {
            val title = fieldName.text.toString()
            val description = fieldDesc.text.toString()
            val price = fieldPrice.text.toString()

            val priceFinal = if (price.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(price)
            }

            val produtc = Produtc(
                title = title,
                description = description,
                price = priceFinal,
                image = url
            )

            val dao = ProductDao()

            if (title.isNotBlank() && description.isNotBlank()) {
                dao.insert(produtc)
            } else {
                Toast.makeText(
                    this,
                    "Não é possivel salvar os produtos pois existem campos em branco",
                    Toast.LENGTH_LONG
                ).show()
            }
            finish()
        }
    }
}