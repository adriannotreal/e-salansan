package com.adrianmarino.e_salansan.chapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianmarino.e_salansan.*
import com.adrianmarino.e_salansan.challenges.Chapter1Challenge
import com.adrianmarino.e_salansan.chapter5lectures.Chapter5Lecture1Activity
import com.adrianmarino.e_salansan.chapter5lectures.Chapter5Lecture2Activity
import com.adrianmarino.e_salansan.chapter6lectures.Chapter6Lecture1Activity
import com.adrianmarino.e_salansan.chapter6lectures.Chapter6Lecture2Activity
import kotlinx.android.synthetic.main.activity_chapter_vi.*

class ChapterViActivity : AppCompatActivity(), OnChapterClickListener {

    private var username : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        setContentView(R.layout.activity_chapter_vi)
        val actionbar = supportActionBar
        actionbar!!.title = "Chapter VI - Non-Linear Data Structure"

        username = intent.getStringExtra(ConstantsQuestionsChapter1.USER_NAME)

        var chapter6LessonList = mutableListOf(
            Chapter("Lesson 1. \nGraph"),
            Chapter("Lesson 2. \nTree")
        )
        val adapter = ChapterAdapter(chapter6LessonList, this)
        rvChapter6Lessons.adapter = adapter
        rvChapter6Lessons.layoutManager = LinearLayoutManager(this)

    }

    override fun onChapterClicked(position: Int) {
        when(position) {
            0 -> { Intent(this, Chapter6Lecture1Activity::class.java).also {
                startActivity(it)
            }
            }
            1 -> { Intent(this, Chapter6Lecture2Activity::class.java).also {
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