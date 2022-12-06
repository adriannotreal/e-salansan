package com.adrianmarino.e_salansan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_set_up_password.*

class SetUpPasswordActivity : AppCompatActivity() {
    private lateinit var username : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_password)



        btnStartTutorial.setOnClickListener {
            var context = this
            val username = intent.getStringExtra(ConstantsQuestionsChapter1.USER_NAME)
            val password = findViewById<EditText>(R.id.etPasswordOL)
            val password1 = findViewById<EditText>(R.id.etRetypePasswordOL)
            Intent(this, MainMenu::class.java).also{
                if (password.text.toString() == password1.text.toString()){
                    var user = User(username.toString(), password.text.toString())
                    var db = DatabaseHandler(context)
                    db.insertData(user)
                    it.putExtra(ConstantsQuestionsChapter1.USER_NAME,username.toString())
                    startActivity(it)
                    finish()
                }
                else
                    Toast.makeText(context, "Password mismatch.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}