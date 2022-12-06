package com.adrianmarino.e_salansan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_queue_algorithm_simulation.*
import kotlinx.android.synthetic.main.activity_stack_algorithm_simulation.*

class QueueAlgorithmSimulationActivity : AppCompatActivity() {

    private lateinit var etSimFirstInput : EditText
    private lateinit var etSimSecondInput : EditText
    private lateinit var etSimThirdInput : EditText
    private lateinit var etSimFourthInput : EditText
    private lateinit var etSimFifthInput : EditText
    private lateinit var etSimSixthInput : EditText
    private lateinit var etSimSeventhInput : EditText
    private lateinit var etInput : EditText
    private lateinit var etTopElement : EditText
    private lateinit var etEmptyFull : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queue_algorithm_simulation)

        var front : Int = 0

        etSimFirstInput = findViewById(R.id.et_sim_first_input_queue)
        etSimSecondInput = findViewById(R.id.et_sim_second_input_queue)
        etSimThirdInput = findViewById(R.id.et_sim_third_input_queue)
        etSimFourthInput = findViewById(R.id.et_sim_fourth_input_queue)
        etSimFifthInput = findViewById(R.id.et_sim_fifth_input_queue)
        etSimSixthInput = findViewById(R.id.et_sim_sixth_input_queue)
        etSimSeventhInput = findViewById(R.id.et_sim_seventh_input_queue)
        etInput = findViewById(R.id.et_number_to_push_queue)
        etTopElement = findViewById(R.id.et_front_element)
        etEmptyFull = findViewById(R.id.et_empty_full_queue)

        etSimFirstInput.visibility = View.INVISIBLE
        etSimSecondInput.visibility = View.INVISIBLE
        etSimThirdInput.visibility = View.INVISIBLE
        etSimFourthInput.visibility = View.INVISIBLE
        etSimFifthInput.visibility = View.INVISIBLE
        etSimSixthInput.visibility = View.INVISIBLE
        etSimSeventhInput.visibility = View.INVISIBLE
        etTopElement.visibility = View.INVISIBLE
        etEmptyFull.visibility = View.INVISIBLE

        btnEnqueue.setOnClickListener {

            if(etInput.text.toString().trim().isEmpty() || etInput.text.toString() == "-" || etInput.text.toString() == "+"){
                Toast.makeText(this, "Please enter a number to enqueue!", Toast.LENGTH_SHORT).show()
            }else{
                when(front){
                    0 -> {
                        etSimSeventhInput.text = etInput.text
                        etInput.setText("")
                        etSimSeventhInput.visibility = View.VISIBLE
                        front++
                    }
                    1 -> {
                        etSimSixthInput.text = etInput.text
                        etInput.setText("")
                        etSimSixthInput.visibility = View.VISIBLE
                        front++
                    }
                    2 -> {
                        etSimFifthInput.text = etInput.text
                        etInput.setText("")
                        etSimFifthInput.visibility = View.VISIBLE
                        front++
                    }
                    3 -> {
                        etSimFourthInput.text = etInput.text
                        etInput.setText("")
                        etSimFourthInput.visibility = View.VISIBLE
                        front++
                    }
                    4 -> {
                        etSimThirdInput.text = etInput.text
                        etInput.setText("")
                        etSimThirdInput.visibility = View.VISIBLE
                        front++
                    }
                    5 -> {
                        etSimSecondInput.text = etInput.text
                        etInput.setText("")
                        etSimSecondInput.visibility = View.VISIBLE
                        front++
                    }
                    6 -> {
                        etSimFirstInput.text = etInput.text
                        etInput.setText("")
                        etSimFirstInput.visibility = View.VISIBLE
                        front++
                    }
                    7 -> {
                        etEmptyFull.setText("The stack is full!")
                        etInput.setText("")
                        etEmptyFull.visibility = View.VISIBLE

                    }
                }
                try {
                    val imm: InputMethodManager =
                        getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
                } catch (e: Exception) {
                    // TODO: handle exception
                }
                etInput.clearFocus()
            }


        }

        btnDequeue.setOnClickListener {
            when(front){
                0 -> {
                    etEmptyFull.setText("The stack is empty!")
                    etInput.setText("")
                    etEmptyFull.visibility = View.VISIBLE
                }
                1 -> {
                    etSimSeventhInput.setText("")
                    etInput.setText("")
                    etSimSeventhInput.visibility = View.INVISIBLE
                    front--
                }
                2 -> {
                    etSimSeventhInput.setText(etSimSixthInput.text)
                    etInput.setText("")
                    etSimSixthInput.visibility = View.INVISIBLE
                    front--
                }
                3 -> {
                    etSimSeventhInput.setText(etSimSixthInput.text)
                    etSimSixthInput.setText(etSimFifthInput.text)
                    etInput.setText("")
                    etSimFifthInput.visibility = View.INVISIBLE
                    front--
                }
                4 -> {
                    etSimSeventhInput.setText(etSimSixthInput.text)
                    etSimSixthInput.setText(etSimFifthInput.text)
                    etSimFifthInput.setText(etSimFourthInput.text)
                    etInput.setText("")
                    etSimFourthInput.visibility = View.INVISIBLE
                    front--
                }
                5 -> {
                    etSimSeventhInput.setText(etSimSixthInput.text)
                    etSimSixthInput.setText(etSimFifthInput.text)
                    etSimFifthInput.setText(etSimFourthInput.text)
                    etSimFourthInput.setText(etSimThirdInput.text)
                    etInput.setText("")
                    etSimThirdInput.visibility = View.INVISIBLE
                    front--
                }
                6 -> {
                    etSimSeventhInput.setText(etSimSixthInput.text)
                    etSimSixthInput.setText(etSimFifthInput.text)
                    etSimFifthInput.setText(etSimFourthInput.text)
                    etSimFourthInput.setText(etSimThirdInput.text)
                    etSimThirdInput.setText(etSimSecondInput.text)
                    etInput.setText("")
                    etSimSecondInput.visibility = View.INVISIBLE
                    front--
                }
                7 -> {
                    etSimSeventhInput.setText(etSimSixthInput.text)
                    etSimSixthInput.setText(etSimFifthInput.text)
                    etSimFifthInput.setText(etSimFourthInput.text)
                    etSimFourthInput.setText(etSimThirdInput.text)
                    etSimThirdInput.setText(etSimSecondInput.text)
                    etSimSecondInput.setText(etSimFirstInput.text)
                    etInput.setText("")
                    etSimFirstInput.visibility = View.INVISIBLE
                    front--
                }
            }
            try {
                val imm: InputMethodManager =
                    getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            } catch (e: Exception) {
                // TODO: handle exception
            }
            etInput.clearFocus()
        }

        btnPeek_queue.setOnClickListener {

            if(front!=0){
                etTopElement.text = etSimSeventhInput.text
                etTopElement.visibility = View.VISIBLE
            }else{
                etEmptyFull.setText("The stack is empty!")
                etEmptyFull.visibility = View.VISIBLE
            }
            try {
                val imm: InputMethodManager =
                    getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
            } catch (e: Exception) {
                // TODO: handle exception
            }
            etInput.clearFocus()
        }

        btnGenerateNumberQueue.setOnClickListener {
            var indexone = (1..99).random()

            etInput.setText(indexone.toString())
        }
    }
}