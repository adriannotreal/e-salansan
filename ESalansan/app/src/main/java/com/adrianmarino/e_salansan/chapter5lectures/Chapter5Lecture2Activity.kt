package com.adrianmarino.e_salansan.chapter5lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter5_lecture2.*

class Chapter5Lecture2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Queue Algorithm"
        setContentView(R.layout.activity_chapter5_lecture2)

        Chapter5Lesson2Content1.text = "Queue is an abstract data structure, somewhat similar to Stacks. Unlike stacks, a queue is open at both its ends. One end is always used to insert data (enqueue) and the other is used to remove data (dequeue). Queue follows First-In-First-Out methodology, i.e., the data item stored first will be accessed first.\n " +
                "A real-world example of queue can be a single-lane one-way road, where the vehicle enters first, exits first. More real-world examples can be seen as queues at the ticket windows and bus-stops."

        Chapter5Lesson2Content1B.text = "Queue operations may involve initializing or defining the queue, utilizing it, and then completely erasing it from the memory. Here we shall try to understand the basic operations associated with queues −\n" +
                "enqueue() − add (store) an item to the queue.\n" +
                "dequeue() − remove (access) an item from the queue.\n\n" +
                "Few more functions are required to make the above-mentioned queue operation efficient. These are −\n" +
                "peek() − Gets the element at the front of the queue without removing it.\n" +
                "isfull() − Checks if the queue is full.\n" +
                "isempty() − Checks if the queue is empty.\n" +
                "In queue, we always dequeue (or access) data, pointed by \"front\" pointer and while enqueing (or storing) data in the queue we take help of \"rear\" pointer."
    }
}