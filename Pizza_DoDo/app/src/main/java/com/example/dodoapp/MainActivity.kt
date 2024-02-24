package com.example.dodoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import com.example.dodoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter:DoDoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapter()
        setupSearchView()
    }

    private fun setupSearchView(){
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                val filteredList = DataSource.list.filter {
                    (it.name.lowercase().contains(newText.lowercase()))
                }
                myAdapter.submitList(filteredList)
                return true
            }
        })
    }

    private fun setupAdapter(){
        myAdapter= DoDoAdapter {
            handlePizzaDidTap(it)
        }
        binding.recyclerView.adapter=myAdapter


        myAdapter.submitList(DataSource.list)
    }

    private fun handlePizzaDidTap(doItem: DoDoItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("PIZZA", doItem)
        startActivity(intent)
    }
}