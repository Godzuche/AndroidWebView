package com.godzuche.androidwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.godzuche.androidwebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val webView = binding.wvGoogle
        webView.loadUrl("https://google.com")

    }
}