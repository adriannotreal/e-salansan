package com.adrianmarino.e_salansan.chapter1lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter1lecture3.*

class Chapter1Lecture3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Need for Data Structure"
        setContentView(R.layout.activity_chapter1lecture3)

        Chapter1Lesson3Content1.text = "As applications are getting complex and data rich, there are three common problems that applications face now-a-days:" +
                "\n\n-Data Search\n-Processor Speed\n-Multiple requests" +
                "\n\nTo solve the above-mentioned problems, data structures come to rescue. \n\nData can be organized in a data structure in such a way" +
                " that all items may not be required to be searched, and the required data can be searched almost instantly." +
                "\n\nSome examples of these problems are:" +
                "\n\nData Search - Consider an inventory of 1 million items of a store. If the application is to " +
                "search an item, it has to search an item in 1 million items every time slowing down the search. " +
                "As data grows, search will become slower." +
                "\n\nProcessor speed − Processor speed although being very high, falls limited if the data grows to billion records." +
                " Managing data efficiently will lessen the toll it takes for the processor to process such data." +
                "\n\nMultiple requests − As thousands of users can search data simultaneously on a web server," +
                " even the fast server fails while searching the data. Creating a system will allow servers to handle the requests."
    }
}