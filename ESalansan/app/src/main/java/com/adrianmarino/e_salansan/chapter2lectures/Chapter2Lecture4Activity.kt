package com.adrianmarino.e_salansan.chapter2lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter2_lecture4.*

class Chapter2Lecture4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Complexity of Algorithm"
        setContentView(R.layout.activity_chapter2_lecture4)

        Chapter2Lesson4Content1.text = "Suppose X is an algorithm and n is the size of input data, the time and space used by " +
                "the algorithm X are the two main factors, which decide the efficiency of X.\n\nTime Factor − Time is measured by counting the number of key operations such as comparisons in the sorting algorithm." +
                "Time complexity of an algorithm represents the amount of time required by the algorithm to run to completion. It grows linearly as the input size increases." +
                "\n\nSpace Factor − Space complexity of an algorithm represents the amount of memory space required by the algorithm in its life cycle.  The space required by an algorithm is equal to the sum of the following two components: \n"+
                "A fixed part that is a space required to store certain data and variables, that are independent of the size of the problem.\n" +
                "A variable part is a space required by variables, whose size depends on the size of the problem.\n\nThe complexity of an algorithm f(n) gives the running time and/or the storage space required by the algorithm in terms of n as the size of input data."

    }
}