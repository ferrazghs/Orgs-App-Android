package br.com.alura.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.databinding.ActivityListProductsBinding
import br.com.alura.orgs.ui.dao.ProductDao
import br.com.alura.orgs.ui.recycleview.adapter.ListProductAdapter

class ListProductsActivity : AppCompatActivity() {

    private val dao = ProductDao()
    private val adapter = ListProductAdapter(products = dao.findAll(), context = this)

    private val binding by lazy {
        ActivityListProductsBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configRecyclerView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.findAll())
    }

    private fun configRecyclerView() {
        val recyclerView = binding.activityListProductsRecyclerview
        recyclerView.adapter = adapter
    }

    private fun configFab() {
        val fab = binding.activityListProductsFab

        fab.setOnClickListener {
            openFormProduct()
        }
    }

    private fun openFormProduct() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)
    }
}