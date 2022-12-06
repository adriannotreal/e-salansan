package com.adrianmarino.e_salansan.chapter2lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter2_lecture2.*

class Chapter2Lecture2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Characteristics of Algorithm"
        setContentView(R.layout.activity_chapter2_lecture2)

        Chapter2Lesson2Content1.text = "Not all procedures can be called an algorithm. An algorithm should have the following characteristics:\n\n"+
                "Unambiguous − Algorithm should be clear and unambiguous. Each of its steps (or phases), " +
                "and their inputs/outputs should be clear and must lead to only one meaning."


        sampleAlgoChar1.setText("Say for example, an array of integers is to be sorted in increasing order, " +
                "bubble sort algorithm promises to fulfill this assignment through each of its steps.")

        Chapter2Lesson2Content1B.text = "\n\nInput − An algorithm should have 0 or more well-defined inputs." +

        sampleAlgoChar2.setText("In the same example, the input will be the elements that are inside the array that are to be sorted using bubble sort.")

        Chapter2Lesson2Content2.text = "\n\nOutput − An algorithm should have 1 or more well-defined outputs, and should match the desired output."

        sampleAlgoChar3.setText("The output of the bubble sort would be the sorted elements of the array.")

        Chapter2Lesson2Content3.text = "\n\nFiniteness − Algorithms must terminate after a finite number of steps."

        sampleAlgoChar4.setText("In the example using bubble sort, the elements will only be sorted within the array.")

        Chapter2Lesson2Content4.text = "\n\nFeasibility − Should be feasible with the available resources."

        sampleAlgoChar5.setText("Using the same example, bubble sort is not suitable for large data sets.")

        Chapter2Lesson2Content5.text = "\n\nIndependent − An algorithm should have step-by-step directions, which should be independent of any programming code.\nNo matter what the " +
                "the programming language is used, bubble sort follows the same procedure.\n\nThis is an example of a bubble sort algorithm:"


        algorithmBubbleSort.setText("begin BubbleSort(list)\n" +
                "\n" +
                "\t\tfor all elements of list\n" +
                "\t\t\t\tif list[i] > list[i+1]\n" +
                "\t\t\t\t\t\tswap(list[i], list[i+1])\n" +
                "\t\t\t\tend if\n" +
                "\t\tend for\n" +
                "\n" +
                "\t\treturn list\n" +
                "\n" +
                "end BubbleSort")
    }
}