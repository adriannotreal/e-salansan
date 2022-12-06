package com.adrianmarino.e_salansan

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_stack_algorithm_simulation.*

class StackAlgorithmSimulationActivity : AppCompatActivity() {

    private lateinit var etSimFirstInput : EditText
    private lateinit var etSimSecondInput : EditText
    private lateinit var etSimThirdInput : EditText
    private lateinit var etSimFourthInput : EditText
    private lateinit var etSimFifthInput : EditText
    private lateinit var etInput : EditText
    private lateinit var etTopElement : EditText
    private lateinit var etEmptyFull : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack_algorithm_simulation)

        var topIndex : Int = 0

        etSimFirstInput = findViewById(R.id.et_sim_first_input_stack)
        etSimSecondInput = findViewById(R.id.et_sim_second_input_stack)
        etSimThirdInput = findViewById(R.id.et_sim_third_input_stack)
        etSimFourthInput = findViewById(R.id.et_sim_fourth_input_stack)
        etSimFifthInput = findViewById(R.id.et_sim_fifth_input_stack)
        etInput = findViewById(R.id.et_number_to_push)
        etTopElement = findViewById(R.id.et_top_element)
        etEmptyFull = findViewById(R.id.et_empty_full)

        etSimFirstInput.visibility = View.INVISIBLE
        etSimSecondInput.visibility = View.INVISIBLE
        etSimThirdInput.visibility = View.INVISIBLE
        etSimFourthInput.visibility = View.INVISIBLE
        etSimFifthInput.visibility = View.INVISIBLE
        etTopElement.visibility = View.INVISIBLE
        etEmptyFull.visibility = View.INVISIBLE

        btnPush.setOnClickListener {

            if(etInput.text.toString().trim().isEmpty() || etInput.text.toString() == "-" || etInput.text.toString() == "+"){
                Toast.makeText(this, "Please enter a number to push!", Toast.LENGTH_SHORT).show()
            }else{
                when(topIndex){
                    0 -> {
                        etSimFifthInput.text = etInput.text
                        etInput.setText("")
                        etSimFifthInput.visibility = View.VISIBLE
                        topIndex++
                    }
                    1 -> {
                        etSimFourthInput.text = etInput.text
                        etInput.setText("")
                        etSimFourthInput.visibility = View.VISIBLE
                        topIndex++
                    }
                    2 -> {
                        etSimThirdInput.text = etInput.text
                        etInput.setText("")
                        etSimThirdInput.visibility = View.VISIBLE
                        topIndex++
                    }
                    3 -> {
                        etSimSecondInput.text = etInput.text
                        etInput.setText("")
                        etSimSecondInput.visibility = View.VISIBLE
                        topIndex++
                    }
                    4 -> {
                        etSimFirstInput.text = etInput.text
                        etInput.setText("")
                        etSimFirstInput.visibility = View.VISIBLE
                        topIndex++
                    }
                    5 -> {
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

        btnPop.setOnClickListener {
            when(topIndex){
                0 -> {
                    etEmptyFull.setText("The stack is empty!")
                    etInput.setText("")
                    etEmptyFull.visibility = View.VISIBLE
                }
                1 -> {
                    etSimFifthInput.setText("")
                    etInput.setText("")
                    etSimFifthInput.visibility = View.INVISIBLE
                    topIndex--
                }
                2 -> {
                    etSimFourthInput.setText("")
                    etInput.setText("")
                    etSimFourthInput.visibility = View.INVISIBLE
                    topIndex--
                }
                3 -> {
                    etSimThirdInput.setText("")
                    etInput.setText("")
                    etSimThirdInput.visibility = View.INVISIBLE
                    topIndex--
                }
                4 -> {
                    etSimSecondInput.setText("")
                    etInput.setText("")
                    etSimSecondInput.visibility = View.INVISIBLE
                    topIndex--
                }
                5 -> {
                    etSimFirstInput.setText("")
                    etInput.setText("")
                    etSimFirstInput.visibility = View.INVISIBLE
                    topIndex--
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

        btnPeek.setOnClickListener {
                when(topIndex){
                    1->{
                        etTopElement.text = etSimFifthInput.text
                        etTopElement.visibility = View.VISIBLE
                    }
                    2->{
                        etTopElement.text = etSimFourthInput.text
                        etTopElement.visibility = View.VISIBLE
                    }
                    3->{
                        etTopElement.text = etSimThirdInput.text
                        etTopElement.visibility = View.VISIBLE
                    }
                    4->{
                        etTopElement.text = etSimSecondInput.text
                        etTopElement.visibility = View.VISIBLE
                    }
                    5->{
                        etTopElement.text = etSimFirstInput.text
                        etTopElement.visibility = View.VISIBLE
                    }
                    else ->{
                        etEmptyFull.setText("The stack is empty!")
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

        btnGenerateNumberStack.setOnClickListener {
            var indexone = (1..99).random()

            etInput.setText(indexone.toString())
        }
    }
}