package com.example.onlineexams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class BiologyActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biology)
        var myDB = FirebaseFirestore.getInstance()


        val docRef: DocumentReference =
            myDB.collection("exams").document("biology")
        docRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document != null) {
                    val english: String? = document.getString("bio")

                    val myWebView: WebView = findViewById(R.id.webviewb)
                    val webSettings: WebSettings = myWebView.getSettings()
                    webSettings.javaScriptEnabled = true
                    myWebView.setWebViewClient(WebViewClient())
                    myWebView.loadUrl(english)

                } else {
                    Log.d("LOGGER", "No such document")
                }
            } else {
                Log.d("LOGGER", "get failed with ", task.exception)
            }
        }

    }
}
