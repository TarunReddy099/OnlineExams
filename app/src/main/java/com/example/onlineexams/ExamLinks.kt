package com.example.onlineexams

import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_exam_links.*


class ExamLinks : AppCompatActivity() {
    var db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exam_links)
        val spin =findViewById<Spinner>(R.id.spinner)
        val url =findViewById<EditText>(R.id.link)



        button.setOnClickListener {
            val field =spin.toString()
            val ssss ="math"
            if (field==ssss) {
                val documentReference: DocumentReference =
                    db.collection("exams").document("math")

                documentReference.update("mexam", url.text.toString()).addOnSuccessListener {
                    Toast.makeText(this, "Document Updated", Toast.LENGTH_LONG).show();
                }.addOnFailureListener {
                    Toast.makeText(this, "Error Please try again ", Toast.LENGTH_LONG).show();
                }
            }
            if(field=="English") {
            val documentReference: DocumentReference =
                db.collection("exams").document("English")

            documentReference.update("eng", url.text.toString()).addOnSuccessListener {
                Toast.makeText(this, "Document Updated", Toast.LENGTH_LONG).show();
            }.addOnFailureListener {
                Toast.makeText(this, "Error Please try again ", Toast.LENGTH_LONG).show();
            }

        } else{
                Toast.makeText(this, "Error  ", Toast.LENGTH_LONG).show();
            }
        }

    }
}
