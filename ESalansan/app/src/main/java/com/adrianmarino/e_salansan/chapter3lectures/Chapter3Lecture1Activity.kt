package com.adrianmarino.e_salansan.chapter3lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter3_lecture1.*

class Chapter3Lecture1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Classification of Data Structure"
        setContentView(R.layout.activity_chapter3_lecture1)

        Chapter3Lesson1Content1.text = "Data Structures are normally classified into two broad categories. \n\n1. Primitive Data Structure" +
                "\n\n2. Non-primitive Data Structure"

        Chapter3Lesson1Content1B.text = "1. Primitive data structures are basic structures and are directly operated upon by machine instructions. " +
                "Primitive data structures have different representations on different computers. Integer, float and character are " +
                "some of the examples of a primitive data structure. These data types are present in almost every programming languages as built-in type.\n \n" +
                "Integer: Is a data type which allows numerical values without the fraction part. It is used as a whole number.\n\n" +
                "Float: Is a data type which is used for storing fractional numbers.\n\n" +
                "Character: Is a data type used for storing character data."

        Chapter3Lesson1Content2.text = "2. Non-primitive data structures are more sophisticated form of data structures which is usually derived from primitive data structures. " +
                "The non-primitive data structures emphasizes on structuring of a group of homogeneous(of different data types) or heterogeneous(of the same data type) data items. " +
                "Non-primitive data structure can be further divided into two categories: \n\n\t\t\ta. Linear Data Structures - Linear data structures are data structures wherein all of its elements are arranged in the linear order. " +
                "In linear data structures, the elements are stored in non-hierarchical way where each element has the successors and predecessors except the first and last element." +
                " Some of its examples are queue, stack and array." +
                "\n\n\t\t\tb. Non-linear Data Structures - Non-linear data structure does not form a sequence i.e. each item or element is connected with two or more other items in a non-linear arrangement. " +
                "The data elements are not arranged in sequential structure. Its examples are graph and tree."
    }
}