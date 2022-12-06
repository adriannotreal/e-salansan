package com.adrianmarino.e_salansan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adrianmarino.e_salansan.admin.AddLectureActivity
import com.adrianmarino.e_salansan.admin.AddQuestionsActivity
import com.adrianmarino.e_salansan.admin.EditLectureActivity
import com.adrianmarino.e_salansan.admin.EditQuestionsActivity
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        btnLogOut.setOnClickListener {
            Intent(this, MainActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }

        btnAddLecture.setOnClickListener {
            Intent(this, AddLectureActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }

        btnUpdateLecture.setOnClickListener {
            Intent(this, EditLectureActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }

        btnAddQuestion.setOnClickListener {
            Intent(this, AddQuestionsActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }

        btnUpdateQuestion.setOnClickListener {
            Intent(this, EditQuestionsActivity::class.java).also{
                startActivity(it)
                finish()
            }
        }
    }
}