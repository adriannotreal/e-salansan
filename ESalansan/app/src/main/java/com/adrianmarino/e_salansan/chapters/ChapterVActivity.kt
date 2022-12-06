package com.adrianmarino.e_salansan.chapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianmarino.e_salansan.*
import com.adrianmarino.e_salansan.challenges.Chapter1Challenge
import com.adrianmarino.e_salansan.chapter3lectures.Chapter3Lecture1Activity
import com.adrianmarino.e_salansan.chapter3lectures.Chapter3Lecture2Activity
import com.adrianmarino.e_salansan.chapter5lectures.Chapter5Lecture1Activity
import com.adrianmarino.e_salansan.chapter5lectures.Chapter5Lecture2Activity
import kotlinx.android.synthetic.main.activity_chapter_v.*

class ChapterVActivity : AppCompatActivity(), OnChapterClickListener {

    private var username : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        setContentView(R.layout.activity_chapter_v)
        val actionbar = supportActionBar
        actionbar!!.title = "Chapter V-Linear Data Structure"

        username = intent.getStringExtra(ConstantsQuestionsChapter1.USER_NAME)

        var chapter5LessonList = mutableListOf(
            Chapter("Lesson 1. \nStack Data Structure"),
            Chapter("Lesson 2. \nQueue Data Structure"),
            Chapter("Stack Data Structure Simulation"),
            Chapter("Queue Data Structure Simulation")
        )
        val adapter = ChapterAdapter(chapter5LessonList, this)
        rvChapter5Lessons.adapter = adapter
        rvChapter5Lessons.layoutManager = LinearLayoutManager(this)

    }

    override fun onChapterClicked(position: Int) {
        when(position) {
            0 -> { Intent(this, Chapter5Lecture1Activity::class.java).also {
                startActivity(it)
            }
            }
            1 -> { Intent(this, Chapter5Lecture2Activity::class.java).also {
                startActivity(it)
            }
            }
            2 -> { Intent(this, StackAlgorithmSimulationActivity::class.java).also {
                startActivity(it)
            }
            }
            3 -> { Intent(this, QueueAlgorithmSimulationActivity::class.java).also {
                startActivity(it)
            }
            }
            5 -> { Intent(this, Chapter1Challenge::class.java).also {
                it.putExtra(ConstantsQuestionsChapter1.USER_NAME,username)
                startActivity(it)
            }
            }

        }
    }
}