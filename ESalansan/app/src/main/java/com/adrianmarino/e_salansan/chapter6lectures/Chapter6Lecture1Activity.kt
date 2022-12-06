package com.adrianmarino.e_salansan.chapter6lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter6_lecture1.*

class Chapter6Lecture1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Graph"
        setContentView(R.layout.activity_chapter6_lecture1)

        Chapter6Lesson1Content1.text = "A graph is a pictorial representation of a set of objects where some pairs of objects are connected by links. The interconnected objects are represented by points termed as vertices, and the links that connect the vertices are called edges.\n" +
                "\n" +
                "Formally, a graph is a pair of sets (V, E), where V is the set of vertices and E is the set of edges, connecting the pairs of vertices."

        Chapter6Lesson1Content1B.text = "Mathematical graphs can be represented in data structure. We can represent a graph using an array of vertices and a two-dimensional array of edges. Before we proceed further, let's familiarize ourselves with some important terms −\n" +
                "\n" +
                "Vertex − Each node of the graph is represented as a vertex. In the following example, the labeled circle represents vertices. Thus, A to G are vertices. We can represent them using an array as shown in the following image. Here A can be identified by index 0. B can be identified using index 1 and so on.\n" +
                "\n" +
                "Edge − Edge represents a path between two vertices or a line between two vertices. In the following example, the lines from A to B, B to C, and so on represents edges. We can use a two-dimensional array to represent an array as shown in the following image. Here AB can be represented as 1 at row 0, column 1, BC as 1 at row 1, column 2 and so on, keeping other combinations as 0.\n" +
                "\n" +
                "Adjacency − Two node or vertices are adjacent if they are connected to each other through an edge. In the following example, B is adjacent to A, C is adjacent to B, and so on.\n" +
                "\n" +
                "Path − Path represents a sequence of edges between the two vertices. In the following example, ABCD represents a path from A to D."

        Chapter6Lesson1Content2.text = "Basic Operations\n" +
                "Following are basic primary operations of a Graph −\n" +
                "\n" +
                "Add Vertex − Adds a vertex to the graph.\n" +
                "\n" +
                "Add Edge − Adds an edge between the two vertices of the graph.\n" +
                "\n" +
                "Display Vertex − Displays a vertex of the graph."
    }
}