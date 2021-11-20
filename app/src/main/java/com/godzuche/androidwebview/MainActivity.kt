package com.godzuche.androidwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.godzuche.androidwebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val webView = binding.wvGoogle
        webView.webViewClient = myWebViewClient()
        webView.loadUrl("https://google.com")

    }

    //webViewClient to display the web page in the app instead of chrome browser
    inner class myWebViewClient: WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            url: String
        ): Boolean {
            view?.loadUrl(url)
            return true
        }
    }
}