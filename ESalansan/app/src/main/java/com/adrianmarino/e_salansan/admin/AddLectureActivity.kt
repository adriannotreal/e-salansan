package com.adrianmarino.e_salansan.admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.AdminActivity
import com.adrianmarino.e_salansan.R
import kotlinx.android.synthetic.main.activity_add_lecture.*

class AddLectureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_lecture)

        btnAddLectureToDB.setOnClickListener {
            Intent(this,AdminActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }
    }
}