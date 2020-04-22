package com.example.onlineexams

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val auth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sbutton.setOnClickListener {
            // get the email and password from the EditText
            val email = emailid.text.toString()
            val password = pass.text.toString()
            // get access to an instance of FirebaseAuth and perform login
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                    // login successful, update the UI
                    Log.e("TAG", it.user.email)
                    val i =Intent(this,ExamLinks::class.java)
                    startActivity(i)
                }
                .addOnFailureListener {
                    // login failed, probably bad email-password combo or a network issue
                    it.printStackTrace()
                }
                .addOnCompleteListener {

                }
        }
    }
}

