package com.adrianmarino.e_salansan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_set_up_account.*

class SetUpAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_up_account)

        btnNextToPassword.setOnClickListener {
            var context = this
            var db = DatabaseHandler(context)
            val username = findViewById<EditText>(R.id.etUsernameOL)
            val username1 : String = username.text.toString()
            Intent(this, SetUpPasswordActivity::class.java).also {
                var data = db.readData()
                if (data.isEmpty()){
                    it.putExtra(ConstantsQuestionsChapter1.USER_NAME, username1)
                    startActivity(it)
                    finish()
                }
                else{
                    for(i in 0 until data.size){
                        if (username.text.toString() == data[i].username.toString()){
                            Toast.makeText(context, "This username already exists!", Toast.LENGTH_SHORT).show()
                            break
                        }
                        if (i == data.size-1){
                            it.putExtra(ConstantsQuestionsChapter1.USER_NAME, username1)
                            startActivity(it)
                            finish()
                        }
                    }
                }

            }
        }
    }
}