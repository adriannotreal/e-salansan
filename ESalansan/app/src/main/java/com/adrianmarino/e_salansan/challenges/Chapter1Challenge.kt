package com.adrianmarino.e_salansan.challenges

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.adrianmarino.e_salansan.*
import kotlinx.android.synthetic.main.activity_chapter1_challenge.*
import kotlinx.android.synthetic.main.activity_set_up_account.*

class Chapter1Challenge : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionsList : ArrayList<QuestionsChapter1Challenge>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswer : Int = 0
    private var mUsername : String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppThemeLectures)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter1_challenge)
        val actionbar = supportActionBar
        actionbar!!.title = "Chapter I - Challenge"

        mUsername=intent.getStringExtra(ConstantsQuestionsChapter1.USER_NAME)
        mQuestionsList = ConstantsQuestionsChapter1.getQuestions()

        setQuestions()

        challenge1_option_one.setOnClickListener(this)
        challenge1_option_two.setOnClickListener(this)
        challenge1_option_three.setOnClickListener(this)
        challenge1_option_four.setOnClickListener(this)
        btn_submit_challenge1.setOnClickListener(this)
    }

    private fun setQuestions(){

        val question = mQuestionsList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit_challenge1.text = "FINISH"
        }else{
            btn_submit_challenge1.text = "SUBMIT"
        }

        progressBarChallenge1.progress = mCurrentPosition
        lbl_progress_challenge1.text = "$mCurrentPosition"+"/"+progressBarChallenge1.max
        tv_question.text = question.question
        challenge1_option_one.text = question.optionOne
        challenge1_option_two.text = question.optionTwo
        challenge1_option_three.text = question.optionThree
        challenge1_option_four.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, challenge1_option_one)
        options.add(1, challenge1_option_two)
        options.add(2, challenge1_option_three)
        options.add(3, challenge1_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.challenge1_option_one -> {
                if(btn_submit_challenge1.text != "GO TO NEXT QUESTION"){
                    selectedOptionView(challenge1_option_one, 1)
                }
            }
            R.id.challenge1_option_two -> {
                if(btn_submit_challenge1.text != "GO TO NEXT QUESTION"){
                    selectedOptionView(challenge1_option_two, 2)
                }
            }
            R.id.challenge1_option_three -> {
                if(btn_submit_challenge1.text != "GO TO NEXT QUESTION"){
                    selectedOptionView(challenge1_option_three, 3)
                }
            }
            R.id.challenge1_option_four -> {
                if(btn_submit_challenge1.text != "GO TO NEXT QUESTION"){
                    selectedOptionView(challenge1_option_four, 4)
                }
            }
            R.id.btn_submit_challenge1 -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestions()
                        }else -> {
                            Intent(this, ResultActivityChapter1Challenge::class.java).also{
                                it.putExtra(ConstantsQuestionsChapter1.USER_NAME, mUsername)
                                it.putExtra(ConstantsQuestionsChapter1.CORRECT_ANSWERS, mCorrectAnswer)
                                it.putExtra(ConstantsQuestionsChapter1.TOTAL_QUESTIONS, mQuestionsList!!.size)
                                startActivity(it)
                                finish()
                            }
                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition-1)

                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit_challenge1.text = "FINISH"
                    }else{
                        btn_submit_challenge1.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 ->{
                challenge1_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 ->{
                challenge1_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 ->{
                challenge1_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 ->{
                challenge1_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

        }
    }

    private fun selectedOptionView(tv: TextView,
                                   selectedOptionNum : Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }


}