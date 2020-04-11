package com.example.onlineexams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class PhysicsActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics)
        webView = findViewById<WebView>(R.id.webviewp)
        webView.webViewClient = WebViewClient()
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled = true
        val url = "https://docs.google.com/forms/d/e/1FAIpQLScmQu1h77WUwjbH6GKXxcaOSDUfNY3RRJatI2f-d7Vqq3q5vg/viewform?usp=sf_link"
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
    }
}
