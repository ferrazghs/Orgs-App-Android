package br.com.alura.orgs.ui.extension

import android.widget.ImageView
import br.com.alura.orgs.R
import coil.load

fun ImageView.loadImage(url: String?) {
    load(url) {
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.placeholder)
    }
}