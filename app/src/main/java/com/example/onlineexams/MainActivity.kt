package com.example.onlineexams

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mathsb.setOnClickListener {
            val i = Intent(this, MathsActivity::class.java)
            startActivity(i)
        }
        physicalsb.setOnClickListener {
            val ii = Intent(this, PhysicsActivity::class.java)
            startActivity(ii)

        }
        engb.setOnClickListener {
            val iii = Intent(this, EnglishActivity::class.java)
            startActivity(iii)
        }
        socialb.setOnClickListener {
            val iiii = Intent(this, SocialActivity::class.java)
            startActivity(iiii)
        }
        biob.setOnClickListener {
            val iiiii = Intent(this, BiologyActivity::class.java)
            startActivity(iiiii)
        }
    }
        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.menu, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle action bar item clicks here.
            val id = item.getItemId()


            if (id == R.id.action_signin) {
                val sign =Intent(this,LoginActivity::class.java)
                startActivity(sign)
                return true
            }


            return super.onOptionsItemSelected(item)


        }

}



