package com.adrianmarino.e_salansan.chapter2lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter2_lecture1.*

class Chapter2Lecture1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "What is Algorithm?"
        setContentView(R.layout.activity_chapter2_lecture1)


        Chapter2Lesson1Content1.text = "Informally, an algorithm is any well-defined computational procedure that takes" +
                    " some value, or set of values, as input and produces some value, or set of values, as" +
                    " output.\n\nAn algorithm is thus a sequence of computational steps that transform the" +
                    "input into the output."

         Chapter2Lesson1Content1B.text = "Algorithms are generally created independent of underlying languages, " +
                    "i.e. an algorithm can be implemented in more than one programming language."

        Chapter2Lesson1Content2.text = "We can also view an algorithm as a tool for solving a well-specified computational problem." +
                "The statement of the problem specifies in general terms the desired input/output relationship. " +
                "The algorithm describes a specific computational procedure for achieving that input/output relationship."

        Chapter2Lesson1Content3.text = "From the data structure point of view, following are some important categories of algorithms −\n\n" +
                "Search − Algorithm to search an item in a data structure.\n" +
                "Sort − Algorithm to sort items in a certain order.\n" +
                "Insert − Algorithm to insert item in a data structure.\n" +
                "Update − Algorithm to update an existing item in a data structure.\n" +
                "Delete − Algorithm to delete an existing item from a data structure."



    }
}