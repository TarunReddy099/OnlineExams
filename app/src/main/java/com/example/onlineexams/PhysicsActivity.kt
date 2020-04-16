package com.example.onlineexams

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class PhysicsActivity : AppCompatActivity() {
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics)
        var myDB = FirebaseFirestore.getInstance()


        val docRef: DocumentReference =
            myDB.collection("exams").document("physics")
        docRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document != null) {
                    val english: String? = document.getString("physicalscience")

                    val myWebView: WebView = findViewById(R.id.webview_phy)
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
