package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.ui.dao.ProductDao
import br.com.alura.orgs.ui.recycleview.adapter.ListProductAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListProductsActivity : AppCompatActivity(R.layout.activity_list_products) {

    private val dao = ProductDao()
    private val adapter = ListProductAdapter(products = dao.findAll(), context = this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.findAll())
    }

    private fun configRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_list_products_recyclerview)
        recyclerView.adapter = adapter
    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_list_products_fab)

        fab.setOnClickListener {
            openFormProduct()
        }
    }

    private fun openFormProduct() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)
    }
}