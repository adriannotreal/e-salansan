package com.adrianmarino.e_salansan.chapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianmarino.e_salansan.*
import com.adrianmarino.e_salansan.challenges.Chapter1Challenge
import com.adrianmarino.e_salansan.chapter2lectures.*
import com.adrianmarino.e_salansan.chapter4lectures.*
import kotlinx.android.synthetic.main.activity_chapter_iv.*

class ChapterIvActivity : AppCompatActivity(), OnChapterClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        setContentView(R.layout.activity_chapter_iv)
        val actionbar = supportActionBar
        actionbar!!.title = "Chapter IV - Searching and Sorting Algorithm"

        var chapter4LessonList = mutableListOf(
            Chapter("Lesson 1. \nSearching Techniques"),
            Chapter("Lesson 2. \nSorting Techniques"),
            Chapter("Linear Search Simulation"),
            Chapter("Binary Search Simulation"),
            Chapter("Bubble Sort Simulation"),
            Chapter("Selection Sort Simulation"),
            Chapter("Insertion Sort Simulation")
        )
        val adapter = ChapterAdapter(chapter4LessonList, this)
        rvChapter4Lessons.adapter = adapter
        rvChapter4Lessons.layoutManager = LinearLayoutManager(this)

    }

    override fun onChapterClicked(position: Int) {

        when(position) {
            0 -> { Intent(this, Chapter4Lecture1Activity::class.java).also {
                startActivity(it)
            }
            }
            1 -> { Intent(this, Chapter4Lecture2Activity::class.java).also {
                startActivity(it)
            }
            }
            2 -> { Intent(this, LinearSearchSimulationActivity::class.java).also {
                startActivity(it)
            }
            }
            3 -> { Intent(this, BinarySearchSimulationActivity::class.java).also {
                startActivity(it)
            }
            }
            4 -> { Intent(this, BubbleSortSimulationActivity::class.java).also {
                startActivity(it)
            }
            }
            5 -> { Intent(this, SelectionSortSimulationActivity::class.java).also {
                startActivity(it)
            }
            }
            6 -> {
                Intent(this, InsertionSortSimulationActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
    }
}