package com.adrianmarino.e_salansan.chapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianmarino.e_salansan.*
import com.adrianmarino.e_salansan.challenges.Chapter1Challenge
import com.adrianmarino.e_salansan.chapter1lectures.Chapter1Lecture1AActivity
import com.adrianmarino.e_salansan.chapter1lectures.Chapter1Lecture2Activity
import com.adrianmarino.e_salansan.chapter1lectures.Chapter1Lecture3Activity
import com.adrianmarino.e_salansan.chapter1lectures.Chapter1Lecture4Activity
import kotlinx.android.synthetic.main.activity_chapter_i.*

class ChapterIActivity : AppCompatActivity(), OnChapterClickListener {

    private var username : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        setContentView(R.layout.activity_chapter_i)
        val actionbar = supportActionBar
        actionbar!!.title = "Chapter I - Introduction"
        username = intent.getStringExtra(ConstantsQuestionsChapter1.USER_NAME)


        var chapter1LessonList = mutableListOf(
            Chapter("Lesson 1. \nIntroduction to Data Structure"),
            Chapter("Lesson 2. \nCharacteristics of Data Structure"),
            Chapter("Lesson 3. \nNeed for Data Structure"),
            Chapter("Lesson 4. \nExecution Time Case"),
            Chapter("Chapter Challenge")
        )
        val adapter = ChapterAdapter(chapter1LessonList, this)
        rvChapter1Lessons.adapter = adapter
        rvChapter1Lessons.layoutManager = LinearLayoutManager(this)

    }

    override fun onChapterClicked(position: Int) {
        when(position) {
            0 -> { Intent(this, Chapter1Lecture1AActivity::class.java).also {
                startActivity(it)
                }
            }
            1 -> { Intent(this, Chapter1Lecture2Activity::class.java).also {
                startActivity(it)
                }
            }
            2 -> { Intent(this, Chapter1Lecture3Activity::class.java).also {
                startActivity(it)
                }
            }
            3 -> { Intent(this, Chapter1Lecture4Activity::class.java).also {
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