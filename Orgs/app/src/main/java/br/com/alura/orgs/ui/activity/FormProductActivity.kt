package br.com.alura.orgs.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.alura.orgs.R
import br.com.alura.orgs.ui.dao.ProductDao
import br.com.alura.orgs.ui.model.Produtc
import java.math.BigDecimal

class FormProductActivity :
    AppCompatActivity(R.layout.activity_form_product) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val buttonSave = findViewById<Button>(R.id.activity_form_product_button_save)
        buttonSave.setOnClickListener {
            val fieldName = findViewById<EditText>(R.id.activity_form_product_title)
            val fieldDesc = findViewById<EditText>(R.id.activity_form_product_description)
            val fieldPrice = findViewById<EditText>(R.id.activity_form_product_price)

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
                Toast.makeText(this, "Não é possivel salvar os produtos pois existem campos em branco", Toast.LENGTH_LONG).show()
            }


            Log.i("FormProduct", "onCreate: $produtc")

            finish()
        }
    }

}