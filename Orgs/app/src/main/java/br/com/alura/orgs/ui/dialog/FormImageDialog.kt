package br.com.alura.orgs.ui.dialog

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import br.com.alura.orgs.databinding.FormAddImageBinding
import br.com.alura.orgs.ui.extension.loadImage

class FormImageDialog(private val context: Context) {

    fun loadImageDialog(
        urlTemplate: String? = null,
        uploadImageListProduct: (url: String) -> Unit
    ) {
        FormAddImageBinding.inflate(LayoutInflater.from(context)).apply {
            urlTemplate?.let {
                formImageviewAddImage.loadImage(it)
                activityFormProductUrl.setText(it)
            }

            buttonUploadImage.setOnClickListener {
                val url = activityFormProductUrl.text.toString()
                val image = formImageviewAddImage

                image.loadImage(url)
            }

            AlertDialog.Builder(context)
                .setView(root)
                .setPositiveButton("Confirmar") { _, _ ->
                    val url = activityFormProductUrl.text.toString()
                    uploadImageListProduct(url)
                }
                .setNegativeButton("Cancelar") { _, _ -> }
                .show()
        }
    }
}