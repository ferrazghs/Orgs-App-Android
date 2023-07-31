package br.com.alura.orgs.ui.dao

import br.com.alura.orgs.ui.model.Produtc
import java.math.BigDecimal

class ProductDao {

    fun insert(product: Produtc) {
        products.add(product)
    }

    fun findAll(): List<Produtc> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Produtc>(
            Produtc(
                title = "Cesta de frutas",
                description = "Morango, Laranja e Limão",
                price = BigDecimal("19.99")
            )
        )
    }

}