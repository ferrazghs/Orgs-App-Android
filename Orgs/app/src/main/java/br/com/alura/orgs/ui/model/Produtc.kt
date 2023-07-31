package br.com.alura.orgs.ui.model

import java.math.BigDecimal

data class Produtc(
    val title: String,
    val description: String,
    val price: BigDecimal,
    var image : String? = null
)