package com.adrianmarino.e_salansan.chapter5lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter5_lecture1.*

class Chapter5Lecture1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Stack Data Structure"
        setContentView(R.layout.activity_chapter5_lecture1)

        Chapter5Lesson1Content1.text = "A stack is an Abstract Data Type (ADT), commonly used in most programming languages. It is named stack as it behaves like a real-world stack, for example – a deck of cards or a pile of plates, etc.\n " +
                "A real-world stack allows operations at one end only. For example, we can place or remove a card or plate from the top of the stack only. Likewise, stack allows all data operations at one end only. At any given time, we can only access the top element of a stack.\n " +
                "This feature makes it LIFO data structure. LIFO stands for Last-in-first-out. Here, the element which is placed (inserted or added) last, is accessed first."

        Chapter5Lesson1Content1B.text = "Stack operations may involve initializing the stack, using it and then de-initializing it. A stack is used for the following two primary operations −\n" +
                "push() − Pushing (storing) an element on the stack.\n" +
                "pop() − Removing (accessing) an element from the stack.\n\n " +
                "To use a stack efficiently, we need to check the status of stack as well. For the same purpose, the following functionality is added to stacks −\n" +
                "peek() − get the top data element of the stack, without removing it.\n" +
                "isFull() − check if stack is full.\n" +
                "isEmpty() − check if stack is empty.\n\n " +
                "At all times, we maintain a pointer to the last PUSHed data on the stack. As this pointer always represents the top of the stack, hence named \"top\". The top pointer provides top value of the stack without actually removing it."
    }
}