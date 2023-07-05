package br.com.alura.orgs.ui.recycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.databinding.LayoutItemBinding
import br.com.alura.orgs.ui.model.Produtc

class ListProductAdapter(
    products: List<Produtc>, private val context: Context

) : RecyclerView.Adapter<ListProductAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    class ViewHolder(binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val title = binding.layoutItemTitle
        val description = binding.layoutItemDescription
        val price = binding.layoutItemPrice

        fun link(product: Produtc) {
            title.text = product.title
            description.text = product.description
            price.text = product.price.toPlainString()
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
