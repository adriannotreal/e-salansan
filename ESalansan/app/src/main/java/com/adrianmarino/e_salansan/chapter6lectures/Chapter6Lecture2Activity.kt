package com.adrianmarino.e_salansan.chapter6lectures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_chapter6_lecture2.*

class Chapter6Lecture2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppThemeLectures)
        val actionbar = supportActionBar
        actionbar!!.title = "Tree"
        setContentView(R.layout.activity_chapter6_lecture2)

        Chapter6Lesson2Content1.text = "Tree represents the nodes connected by edges. We will discuss binary tree or binary search tree specifically."

        Chapter6Lesson2Content1B.text = "Binary Tree is a special datastructure used for data storage purposes. A binary tree has a special condition that each node can have a maximum of two children. A binary tree has the benefits of both an ordered array and a linked list as search is as quick as in a sorted array and insertion or deletion operation are as fast as in linked list."

        Chapter6Lesson2Content2.text = "Following are the important terms with respect to tree.\n" +
                "Path − Path refers to the sequence of nodes along the edges of a tree.\n" +
                "Root − The node at the top of the tree is called root. There is only one root per tree and one path from the root node to any node.\n" +
                "Parent − Any node except the root node has one edge upward to a node called parent.\n" +
                "Child − The node below a given node connected by its edge downward is called its child node.\n" +
                "Leaf − The node which does not have any child node is called the leaf node.\n" +
                "Subtree − Subtree represents the descendants of a node.\n" +
                "Visiting − Visiting refers to checking the value of a node when control is on the node.\n" +
                "Traversing − Traversing means passing through nodes in a specific order.\n" +
                "Levels − Level of a node represents the generation of a node. If the root node is at level 0, then its next child node is at level 1, its grandchild is at level 2, and so on.\n" +
                "keys − Key represents a value of a node based on which a search operation is to be carried out for a node."

        Chapter6Lesson2Content3.text = "Binary Search tree exhibits a special behavior. A node's left child must have a value less than its parent's value and the node's right child must have a value greater than its parent value.\n"

        Chapter6Lesson2Content4.text = "The basic operations that can be performed on a binary search tree data structure, are the following −\n" +
                "Insert − Inserts an element in a tree/create a tree.\n" +
                "Search − Searches an element in a tree.\n" +
                "Pre-order Traversal − Traverses a tree in a pre-order manner.\n" +
                "Inorder Traversal − Traverses a tree in an in-order manner.\n" +
                "Post-order Traversal − Traverses a tree in a post-order manner."
    }
}