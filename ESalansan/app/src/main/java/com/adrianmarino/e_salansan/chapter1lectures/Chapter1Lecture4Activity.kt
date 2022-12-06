package com.adrianmarino.e_salansan.chapter1lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter1lecture4.*

class Chapter1Lecture4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Execution Time Case"
        setContentView(R.layout.activity_chapter1lecture4)

        Chapter1Lesson4Content1.text = "There are three cases which are usually used to compare various data structure's execution time in a relative manner." +
                "\n\n1. Worst Case - The scenario where a specific Data structure operations take the maximum time it can take. " +
                "\n\n2. Average Case - This is the scenario that depicts the average execution time of the operation of a Data Structure. " +
                "\n\n3. Best Case - The scenario that takes the least execution time to perform a Data Structure’s operation."

        Chapter1Lesson4Content1B.text = "\nThis can easily be represented in a linear search scenarios. These are the instances of each cases:" +
                "\n\nWorst Case - For linear search, the worst case happens when the element to be searched is not found in the array. " +
                "The search function will compare the element to all the elements present one by one."

        Chapter1Lesson4Content2.text =   "Average Case - For linear search, the average case happens in the occasion wherein we know that all the cases are uniformly distributed."

         Chapter1Lesson4Content3.text = "Best Case - For linear search, the best case happens when the element is present in the first location. The program will " +
                "not look further into the array as the element has already been found."


        }
}