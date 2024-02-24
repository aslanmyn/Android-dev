package com.example.dodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dodoapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = intent.getSerializableExtra("PIZZA") as DoDoItem
        binding.imageView.setImageResource(item.imgSource)
        binding.title.text = item.name
        binding.description.text = item.description
        binding.price.text= String.format("To cart for %s ₸",item.price)
    }
}