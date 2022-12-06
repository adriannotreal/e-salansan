package com.adrianmarino.e_salansan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.Toast
import com.adrianmarino.e_salansan.admin.EditQuestionsActivity
import com.adrianmarino.e_salansan.challenges.Chapter1Challenge
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)



        splashIcon.alpha = 0f
        splashIcon.animate().setDuration(3000).alpha(1f).withEndAction{
            var context = this
            var db = DatabaseHandler(context)
            var data = db.readData()
            if ((data.isEmpty())){
                Intent(this, FirstInstanceActivity::class.java).also{
                    startActivity(it)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    finish()
                }
            }
            else{
                Intent(this, MainMenu::class.java).also{
                    it.putExtra(ConstantsQuestionsChapter1.USER_NAME, data[0].username.toString())
                    startActivity(it)
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                    finish()
                }
            }
        }
    }
}