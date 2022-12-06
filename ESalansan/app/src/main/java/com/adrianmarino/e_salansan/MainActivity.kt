package com.adrianmarino.e_salansan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)

        btnLogIn.setOnClickListener{

            if(etUsernameLogIn.text.toString() == "admin"){
                Intent(this, AdminActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            }else{
                Intent(this, MainMenu::class.java).also {
                    startActivity(it)
                    finish()
                }
            }

        }
        txtSignUp.setOnClickListener{
            Intent(this, FirstInstanceActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}