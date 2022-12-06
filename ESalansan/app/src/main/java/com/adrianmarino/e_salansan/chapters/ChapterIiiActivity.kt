package com.adrianmarino.e_salansan.chapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianmarino.e_salansan.*
import com.adrianmarino.e_salansan.challenges.Chapter1Challenge
import com.adrianmarino.e_salansan.chapter2lectures.*
import com.adrianmarino.e_salansan.chapter3lectures.Chapter3Lecture1Activity
import com.adrianmarino.e_salansan.chapter3lectures.Chapter3Lecture2Activity
import kotlinx.android.synthetic.main.activity_chapter_iii.*

class ChapterIiiActivity : AppCompatActivity(), OnChapterClickListener {

    private var username : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        setContentView(R.layout.activity_chapter_iii)
        val actionbar = supportActionBar
        actionbar!!.title = "Chapter III-Data Structures Basic Concepts"

        username = intent.getStringExtra(ConstantsQuestionsChapter1.USER_NAME)

        var chapter3LessonList = mutableListOf(
            Chapter("Lesson 1. \nClassification"),
            Chapter("Lesson 2. \nOperation")
        )
        val adapter = ChapterAdapter(chapter3LessonList, this)
        rvChapter3Lessons.adapter = adapter
        rvChapter3Lessons.layoutManager = LinearLayoutManager(this)

    }

    override fun onChapterClicked(position: Int) {
        when(position) {
            0 -> { Intent(this, Chapter3Lecture1Activity::class.java).also {
                startActivity(it)
            }
            }
            1 -> { Intent(this, Chapter3Lecture2Activity::class.java).also {
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