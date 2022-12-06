package com.adrianmarino.e_salansan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result_chapter1_challenge.*

class ResultActivityChapter1Challenge : AppCompatActivity() {

    private var previous_high_score : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_chapter1_challenge)

        val username : String? = intent.getStringExtra(ConstantsQuestionsChapter1.USER_NAME)
        lblName.text = username.toString()

        val totalQuestions = intent.getIntExtra(ConstantsQuestionsChapter1.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(ConstantsQuestionsChapter1.CORRECT_ANSWERS,0)

        setupDisplay(username.toString(), correctAnswers)

        lblScore.text = "Your score is $correctAnswers out of $totalQuestions!\n" +
                "Your previous high score is $previous_high_score."

        btnFinish.setOnClickListener {
            Intent(this, MainMenu::class.java).also{
                it.putExtra(ConstantsQuestionsChapter1.USER_NAME, username)
                startActivity(it)
                finish()
            }
        }
    }

    private fun setupDisplay(username:String, high_score : Int){
        var context = this
        var db = DatabaseHandler(context)
        var data = db.readData()
        for(i in 0 until data.size){
            if (username == data[i].username.toString()){
                previous_high_score = data[i].challenge1_high_score.toInt()
                if(high_score > data[i].challenge1_high_score.toInt()){
                    db.updateChallenge1HighScoreData(high_score,data[i].id)
                    break
                }
            }
        }
    }
}