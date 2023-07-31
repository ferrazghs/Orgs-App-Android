package br.com.alura.orgs.ui.recycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.databinding.LayoutItemBinding
import br.com.alura.orgs.ui.extension.loadImage
import br.com.alura.orgs.ui.model.Produtc
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class ListProductAdapter(
    products: List<Produtc>, private val context: Context

) : RecyclerView.Adapter<ListProductAdapter.ViewHolder>() {
    private val products = products.toMutableList()

    inner class ViewHolder(binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val title = binding.layoutItemTitle
        private val description = binding.layoutItemDescription
        private val price = binding.layoutItemPrice
        private val image = binding.imageView

        fun link(product: Produtc) {
            title.text = product.title
            description.text = product.description
            price.text = convertCurrency(product.price)

            val visibility = if (product.image != null) {
                View.VISIBLE
            } else {
                View.GONE
            }

            image.visibility = visibility

            image.loadImage(product.image)
        }

        private fun convertCurrency(price: BigDecimal): String {
            val currencyReal = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return currencyReal.format(price)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            LayoutItemBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.link(product)
    }

    fun update(products: List<Produtc>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}
