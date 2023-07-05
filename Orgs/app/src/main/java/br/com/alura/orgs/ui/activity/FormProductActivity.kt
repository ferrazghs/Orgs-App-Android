package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.databinding.ActivityFormProductBinding
import br.com.alura.orgs.ui.dao.ProductDao
import br.com.alura.orgs.ui.model.Produtc
import java.math.BigDecimal

class FormProductActivity :
    AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFormProductBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val buttonSave = binding.activityFormProductButtonSave
        buttonSave.setOnClickListener {
            val fieldName = binding.activityFormProductTitle
            val fieldDesc = binding.activityFormProductDescription
            val fieldPrice = binding.activityFormProductPrice

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
                price = priceFinal
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