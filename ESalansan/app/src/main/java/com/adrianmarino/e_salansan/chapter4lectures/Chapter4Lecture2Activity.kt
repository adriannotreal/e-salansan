package com.adrianmarino.e_salansan.chapter4lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter4_lecture1.*
import kotlinx.android.synthetic.main.activity_chapter4_lecture2.*

class Chapter4Lecture2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Sorting Techniques"
        setContentView(R.layout.activity_chapter4_lecture2)

        Chapter4Lesson2Content1.text = "Sorting is nothing but arranging the data in ascending or descending order. Sorting arranges data in a sequence which makes searching easier.\n" +
                "A sorting algorithm is used to rearrange a given array or list elements according to a comparison operator on the elements. The comparison operator is used to decide the new order of element in the respective data structure."

        Chapter4Lesson2Content1B.text = "Bubble sort is a simple sorting algorithm. This sorting algorithm is comparison-based algorithm in which each pair of adjacent elements is compared and the elements are swapped if they are not in order."

        Chapter4Lesson2Content2.text = "Insertion sort is an in-place comparison-based sorting algorithm. Here, a sub-list is maintained which is always sorted. For example, the lower part of an array is maintained to be sorted. An element which is to be 'insert'ed in this sorted sub-list, has to find its appropriate place and then it has to be inserted there. Hence the name, insertion sort.\n" +
                "\n" +
                "The array is searched sequentially and unsorted items are moved and inserted into the sorted sub-list (in the same array)."

        Chapter4Lesson2Content3.text = "Selection sort is a simple sorting algorithm. This sorting algorithm is an in-place comparison-based algorithm in which the list is divided into two parts, the sorted part at the left end and the unsorted part at the right end. Initially, the sorted part is empty and the unsorted part is the entire list.\n" +
                "\n" +
                "The smallest element is selected from the unsorted array and swapped with the leftmost element, and that element becomes a part of the sorted array. This process continues moving unsorted array boundary by one element to the right."
    }
}