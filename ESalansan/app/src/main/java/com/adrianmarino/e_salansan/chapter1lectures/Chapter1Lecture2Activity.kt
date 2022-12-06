package com.adrianmarino.e_salansan.chapter1lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter1lecture2.*

class Chapter1Lecture2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Characteristics of Data Structure"
        setContentView(R.layout.activity_chapter1lecture2)


        Chapter1Lesson2Content1.text = "Data Structures study covers the following points:" +
                "\n\n-Amount of memory require to store data " +
                "\n-Amount of time required to process data" +
                "\n-Representation of data in memory" +
                "\n-Operations performed on the data\n\n\nHence, these are the characteristics of Data Structure:" +
        "\n\nCorrectness − Data structure implementation should implement its interface correctly. This also tackles the importance" +
                " of how data is represented." +
                "\n\nTime Complexity − Running time or the execution time of operations of data structure must be as small as possible." +
                "\n\nSpace Complexity − Memory usage of a data structure operation should be as little as possible."
    }
}