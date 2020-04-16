package com.example.onlineexams

import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore





class MathsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maths)
        var myDB = FirebaseFirestore.getInstance()


        val docRef: DocumentReference =
            myDB.collection("exams").document("math")
        docRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document != null) {
                    val title: String? = document.getString("mexam")

                    val myWebView: WebView = findViewById(R.id.webview)
                    val webSettings: WebSettings = myWebView.getSettings()
                    webSettings.javaScriptEnabled = true
                    myWebView.setWebViewClient(WebViewClient())
                    myWebView.loadUrl(title)

                } else {
                    Log.d("LOGGER", "No such document")
                }
            } else {
                Log.d("LOGGER", "get failed with ", task.exception)
            }
        }






    }
}
