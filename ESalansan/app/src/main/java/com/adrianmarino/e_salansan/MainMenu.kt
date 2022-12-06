package com.adrianmarino.e_salansan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.sax.StartElementListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrianmarino.e_salansan.chapters.*
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity(), OnChapterClickListener {
    private var usernamecontainer : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        val username = intent.getStringExtra(ConstantsQuestionsChapter1.USER_NAME)
        usernamecontainer = username!!

        lblHello.text = "Hi $username!"
        var chapterList = mutableListOf(
            Chapter("Chapter I. \nIntroduction"),
            Chapter("Chapter II. \nAlgorithm"),
            Chapter("Chapter III. \nData Structure and Basic Concepts"),
            Chapter("Chapter IV. \nSearching and Sorting Algorithm"),
            Chapter("Chapter V. \nLinear Data Structure"),
            Chapter("Chapter VI. \nNon-Linear Data Structure")
        )
        val adapter = ChapterAdapter(chapterList, this)
        rvChapters.adapter = adapter
        rvChapters.layoutManager = LinearLayoutManager(this)

        profileIcon.setOnClickListener {
            Intent(this, ProfileActivity::class.java).also {
                it.putExtra(ConstantsQuestionsChapter1.USER_NAME, username.toString())
                startActivity(it)
            }
        }
    }

    override fun onChapterClicked(position: Int) {
        when(position) {
            0 -> { Intent(this, ChapterIActivity::class.java).also {
                it.putExtra(ConstantsQuestionsChapter1.USER_NAME,usernamecontainer)
                startActivity(it)}}
            1 -> { Intent(this, ChapterIiActivity::class.java).also {
                startActivity(it)}}
            2 -> { Intent(this, ChapterIiiActivity::class.java).also {
                startActivity(it)}}
            3 -> { Intent(this, ChapterIvActivity::class.java).also {
                startActivity(it)}}
            4 -> {Intent(this, ChapterVActivity::class.java).also {
                startActivity(it)}}
            else -> {Intent(this, ChapterViActivity::class.java).also {
                startActivity(it)}}
        }


    }
}