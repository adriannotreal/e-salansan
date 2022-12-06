package com.adrianmarino.e_salansan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first_instance.*

class FirstInstanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_instance)

        lblStart.setOnClickListener {
            Intent(this, SetUpAccountActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }


    }
}