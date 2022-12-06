package com.adrianmarino.e_salansan.chapter1lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter1_lecture1_a.*

class Chapter1Lecture1AActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Introduction to Data Structure"
        setContentView(R.layout.activity_chapter1_lecture1_a)

        Chapter1Lesson1Content1.text = "Data Structures is a systematic way to organize data in order to use it efficiently.\n\nFor example, we can store a list of items having the same data-type using the array data structure."

        LabelC1L1I1.text = "Array Data Structure"

        Chapter1Lesson1Content1B.text = "Data Structure can also be defined as the representation of the logical relationships between individual elements" +
                " of data."

        LabelC1L1I2.text = "Tree Data Structure"

        Chapter1Lesson1Content2.text =  "In discussing data structures, it is important to understand the difference between a" +
                " data structure's interface and its implementation, the two foundation terms in Data Structure. " +
                "\n\nAn interface describes what a data structure does, while an implementation describes how the data structure does it."

        Chapter1Lesson1Content3.text = "Interface − sometimes also called an abstract data type, defines the set of operations supported by a data structure " +
                "and the semantics, or meaning, of those operations. " +
                "Each data structure has an interface. An interface only provides the list of " +
                "supported operations, type of parameters they can accept and return type of these operations.\n\nImplementation − provides the internal representation of a data structure. " +
                "Implementation also provides the definition of the algorithms used in the operations of the data structure." +
                "Thus, there can be many implementations of a single interface.\n\nFor example, there are implementations of the List interface using arrays and " +
                "there are implementations of the List " +
                "interface using pointer-based data structures such as linked lists." +
                "\nEach implements the same interface, List, but in different ways."

    }

}