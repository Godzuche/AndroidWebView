package com.godzuche.androidwebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.godzuche.androidwebview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        webView = binding.wvGoogle
        webView.webViewClient = object : myWebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Toast.makeText(this@MainActivity, "Page loaded", Toast.LENGTH_SHORT).show()
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                Toast.makeText(this@MainActivity, "Error occurred!", Toast.LENGTH_SHORT).show()
            }
        }
        webView.loadUrl("https://google.com")

    }

    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }

    //webViewClient to display the web page in the app instead of chrome browser
    open inner class myWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            url: String,
        ): Boolean {
            view?.loadUrl(url)
            return true
        }
    }
}