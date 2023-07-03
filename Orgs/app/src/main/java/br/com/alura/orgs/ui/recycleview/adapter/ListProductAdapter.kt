package br.com.alura.orgs.ui.recycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.ui.model.Produtc

class ListProductAdapter(
    products: List<Produtc>, private val context: Context

) : RecyclerView.Adapter<ListProductAdapter.ViewHolder>() {

    private val products = products.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun link(product: Produtc) {
            val title = itemView.findViewById<TextView>(R.id.layout_item_title)
            val description = itemView.findViewById<TextView>(R.id.layout_item_description)
            val price = itemView.findViewById<TextView>(R.id.layout_item_price)

            title.text = product.title
            description.text = product.description
            price.text = product.price.toPlainString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.layout_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produtc = products[position]
        holder.link(produtc)
    }

    fun update(products: List<Produtc>) {
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

}
