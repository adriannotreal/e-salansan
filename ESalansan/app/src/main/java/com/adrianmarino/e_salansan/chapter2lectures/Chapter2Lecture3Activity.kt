package com.adrianmarino.e_salansan.chapter2lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter2_lecture2.*
import kotlinx.android.synthetic.main.activity_chapter2_lecture3.*

class Chapter2Lecture3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Analysis of Algorithm"
        setContentView(R.layout.activity_chapter2_lecture3)

        Chapter2Lesson3Content1.text = "The goal of the analysis of algorithms is to compare algorithms (or solutions) mainly in terms of" +
                "running time but also in terms of other factors (e.g., memory, developer effort, etc.)\n\nTo analyze the given algorithm, we need to know with which inputs the algorithm takes less time " +
                "(performing well) and with which inputs the algorithm takes a long time.\n\nEfficiency of an algorithm can be analyzed at two different stages, before implementation and after implementation." +
                "\n\nPriori Analysis − This is a theoretical analysis of an algorithm. Efficiency of an algorithm is measured by assuming that all other factors, for example, processor speed, are constant and have no effect on the implementation." +
                "\n\nPosteriori Analysis − This is an empirical analysis of an algorithm. The selected algorithm is implemented using programming language. This is then executed on target computer machine. " +
                "In this analysis, actual statistics like running time and space required, are collected."


        Chapter2Lesson3Content1B.text = "\n\nAsymptotic analysis of an algorithm refers to defining the mathematical boundation/framing of its run-time performance. " +
                "It is the process of calculating the running time of an algorithm in mathematical units to find the program's limitations, or “run-time performance.” " +
                "Using asymptotic analysis, we can very well conclude the best case, average case, and worst case scenario of an algorithm." +
                "\n\nUsually, the time required by an algorithm falls under three types −\n\n" +
                "Best Case − Minimum time required for program execution.\n" +
                "Average Case − Average time required for program execution.\n" +
                "Worst Case − Maximum time required for program execution."


    }
}