package com.adrianmarino.e_salansan.chapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianmarino.e_salansan.*
import com.adrianmarino.e_salansan.challenges.Chapter1Challenge
import com.adrianmarino.e_salansan.chapter2lectures.*
import kotlinx.android.synthetic.main.activity_chapter_ii.*

class ChapterIiActivity : AppCompatActivity(), OnChapterClickListener {

    private var username : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        setContentView(R.layout.activity_chapter_ii)
        val actionbar = supportActionBar
        actionbar!!.title = "Chapter II - Algorithm"
        username = intent.getStringExtra(ConstantsQuestionsChapter1.USER_NAME)

        var chapter2LessonList = mutableListOf(
            Chapter("Lesson 1. \nWhat is Algorithm?"),
            Chapter("Lesson 2. \nCharacteristics of Algorithm"),
            Chapter("Lesson 3. \nAnalysis"),
            Chapter("Lesson 4. \nComplexity")
        )
        val adapter = ChapterAdapter(chapter2LessonList, this)
        rvChapter2Lessons.adapter = adapter
        rvChapter2Lessons.layoutManager = LinearLayoutManager(this)

    }

    override fun onChapterClicked(position: Int) {
        when(position) {
            0 -> { Intent(this, Chapter2Lecture1Activity::class.java).also {
                startActivity(it)
            }
            }
            1 -> { Intent(this, Chapter2Lecture2Activity::class.java).also {
                startActivity(it)
            }
            }
            2 -> { Intent(this, Chapter2Lecture3Activity::class.java).also {
                startActivity(it)
            }
            }
            3 -> { Intent(this, Chapter2Lecture4Activity::class.java).also {
                startActivity(it)
            }
            }
            4 -> { Intent(this, Chapter1Challenge::class.java).also {
                it.putExtra(ConstantsQuestionsChapter1.USER_NAME,username)
                startActivity(it)
            }
            }

        }
    }

}