package br.com.alura.orgs.ui.dao

import br.com.alura.orgs.ui.model.Produtc

class ProductDao {

    fun insert(product: Produtc) {
        products.add(product)
    }

    fun findAll(): List<Produtc> {
        return products.toList()
    }

    companion object {
        private val products = mutableListOf<Produtc>()
    }

}