package com.adrianmarino.e_salansan

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_bubble_sort_simulation.*
import kotlinx.android.synthetic.main.activity_insertion_sort_simulation.*
import kotlinx.android.synthetic.main.activity_selection_sort_simulation.*

class InsertionSortSimulationActivity : AppCompatActivity() {

    private lateinit var etSimFirstInput : EditText
    private lateinit var etSimSecondInput : EditText
    private lateinit var etSimThirdInput : EditText
    private lateinit var etSimFourthInput : EditText
    private lateinit var etSimFifthInput : EditText
    private lateinit var etSimSixthInput : EditText
    private lateinit var etSimSeventhInput : EditText

    private lateinit var ivSimFirstIndexArrow : ImageView
    private lateinit var ivSimSecondIndexArrow : ImageView
    private lateinit var ivSimThirdIndexArrow : ImageView
    private lateinit var ivSimFourthIndexArrow : ImageView
    private lateinit var ivSimFifthIndexArrow : ImageView
    private lateinit var ivSimSixthIndexArrow : ImageView
    private lateinit var ivSimSeventhIndexArrow : ImageView

    private var location = 1
    private var position = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertion_sort_simulation)

        etSimFirstInput = findViewById(R.id.et_sim_first_input_insertion)
        etSimSecondInput = findViewById(R.id.et_sim_second_input_insertion)
        etSimThirdInput = findViewById(R.id.et_sim_third_input_insertion)
        etSimFourthInput = findViewById(R.id.et_sim_fourth_input_insertion)
        etSimFifthInput = findViewById(R.id.et_sim_fifth_input_insertion)
        etSimSixthInput = findViewById(R.id.et_sim_sixth_input_insertion)
        etSimSeventhInput = findViewById(R.id.et_sim_seventh_input_insertion)

        ivSimFirstIndexArrow = findViewById(R.id.et_sim_first_data_image_insertion)
        ivSimSecondIndexArrow = findViewById(R.id.et_sim_second_data_image_insertion)
        ivSimThirdIndexArrow = findViewById(R.id.et_sim_third_data_image_insertion)
        ivSimFourthIndexArrow = findViewById(R.id.et_sim_fourth_data_image_insertion)
        ivSimFifthIndexArrow = findViewById(R.id.et_sim_fifth_data_image_insertion)
        ivSimSixthIndexArrow = findViewById(R.id.et_sim_sixth_data_image_insertion)
        ivSimSeventhIndexArrow = findViewById(R.id.et_sim_seventh_data_image_insertion)

        setDefaultBackground()
        btnCheckInsertionSort.text = "CHECK"
        btnCheckInsertionSort.isEnabled = false

        btnSimulateInsertion.setOnClickListener {
            if(inputCheck()){
                Toast.makeText(this, "Please fill up the whole array with numbers!", Toast.LENGTH_SHORT).show()
            }else{
                disableViews()
            }
        }
        btnCheckInsertionSort.setOnClickListener {
            when(btnCheckInsertionSort.text){
                "NEXT" -> {
                    simulateInsertion()
                }
                "CHECK" -> {
                    checkArray()
                }
                "FINISH" -> {
                    setDefaultBackground()
                    enableViews()
                    etSimFirstInput.setText("")
                    etSimSecondInput.setText("")
                    etSimThirdInput.setText("")
                    etSimFourthInput.setText("")
                    etSimFifthInput.setText("")
                    etSimSixthInput.setText("")
                    etSimSeventhInput.setText("")
                    btnCheckInsertionSort.text = "CHECK"
                    location = 1
                    position = 1
                }
            }
        }

        btnGenerateArrayInsertion.setOnClickListener {
            generateNumbers()
        }
    }

    private fun simulateInsertion(){
        var temp : Int
        when(position){
            1 -> {
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                location++
                position++
                btnCheckInsertionSort.text = "CHECK"
            }
            2 -> {
                if(Integer.parseInt(etSimSecondInput.text.toString()) < Integer.parseInt(etSimFirstInput.text.toString())) {
                    temp = Integer.parseInt(etSimSecondInput.text.toString())
                    etSimSecondInput.setText(etSimFirstInput.text.toString())
                    etSimFirstInput.setText(temp.toString())
                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                    position++
                    location = position
                }else{
                    position++
                    location = position
                }
                btnCheckInsertionSort.text = "CHECK"
            }
            3 -> {
                when(location){
                    2 -> {
                        if(Integer.parseInt(etSimSecondInput.text.toString()) < Integer.parseInt(etSimFirstInput.text.toString())) {
                            temp = Integer.parseInt(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(etSimFirstInput.text.toString())
                            etSimFirstInput.setText(temp.toString())
                            etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            position++
                            location = position
                        }else{
                            position++
                            location = position
                        }
                    }
                    3 -> {
                        if(Integer.parseInt(etSimThirdInput.text.toString()) < Integer.parseInt(etSimSecondInput.text.toString())) {
                            temp = Integer.parseInt(etSimThirdInput.text.toString())
                            etSimThirdInput.setText(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(temp.toString())
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }
                }
                btnCheckInsertionSort.text = "CHECK"
            }
            4 -> {
                when(location){
                    2 -> {
                        if(Integer.parseInt(etSimSecondInput.text.toString()) < Integer.parseInt(etSimFirstInput.text.toString())) {
                            temp = Integer.parseInt(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(etSimFirstInput.text.toString())
                            etSimFirstInput.setText(temp.toString())
                            etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            position++
                            location = position
                        }else{
                            position++
                            location = position
                        }
                    }
                    3 -> {
                        if(Integer.parseInt(etSimThirdInput.text.toString()) < Integer.parseInt(etSimSecondInput.text.toString())) {
                            temp = Integer.parseInt(etSimThirdInput.text.toString())
                            etSimThirdInput.setText(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(temp.toString())
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }

                    4 -> {
                        if(Integer.parseInt(etSimFourthInput.text.toString()) < Integer.parseInt(etSimThirdInput.text.toString())) {
                            temp = Integer.parseInt(etSimFourthInput.text.toString())
                            etSimFourthInput.setText(etSimThirdInput.text.toString())
                            etSimThirdInput.setText(temp.toString())
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }
                }
                btnCheckInsertionSort.text = "CHECK"
            }
            5 -> {

                when(location){
                    2 -> {
                        if(Integer.parseInt(etSimSecondInput.text.toString()) < Integer.parseInt(etSimFirstInput.text.toString())) {
                            temp = Integer.parseInt(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(etSimFirstInput.text.toString())
                            etSimFirstInput.setText(temp.toString())
                            etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            position++
                            location = position
                        }else{
                            position++
                            location = position
                        }
                    }
                    3 -> {
                        if(Integer.parseInt(etSimThirdInput.text.toString()) < Integer.parseInt(etSimSecondInput.text.toString())) {
                            temp = Integer.parseInt(etSimThirdInput.text.toString())
                            etSimThirdInput.setText(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(temp.toString())
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }

                    4 -> {
                        if(Integer.parseInt(etSimFourthInput.text.toString()) < Integer.parseInt(etSimThirdInput.text.toString())) {
                            temp = Integer.parseInt(etSimFourthInput.text.toString())
                            etSimFourthInput.setText(etSimThirdInput.text.toString())
                            etSimThirdInput.setText(temp.toString())
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }

                    5 -> {
                        if(Integer.parseInt(etSimFifthInput.text.toString()) < Integer.parseInt(etSimFourthInput.text.toString())) {
                            temp = Integer.parseInt(etSimFifthInput.text.toString())
                            etSimFifthInput.setText(etSimFourthInput.text.toString())
                            etSimFourthInput.setText(temp.toString())
                            etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }
                }
                btnCheckInsertionSort.text = "CHECK"

            }
            6 -> {
                when(location){
                    2 -> {
                        if(Integer.parseInt(etSimSecondInput.text.toString()) < Integer.parseInt(etSimFirstInput.text.toString())) {
                            temp = Integer.parseInt(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(etSimFirstInput.text.toString())
                            etSimFirstInput.setText(temp.toString())
                            etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            position++
                            location = position
                        }else{
                            position++
                            location = position
                        }
                    }
                    3 -> {
                        if(Integer.parseInt(etSimThirdInput.text.toString()) < Integer.parseInt(etSimSecondInput.text.toString())) {
                            temp = Integer.parseInt(etSimThirdInput.text.toString())
                            etSimThirdInput.setText(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(temp.toString())
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }

                    4 -> {
                        if(Integer.parseInt(etSimFourthInput.text.toString()) < Integer.parseInt(etSimThirdInput.text.toString())) {
                            temp = Integer.parseInt(etSimFourthInput.text.toString())
                            etSimFourthInput.setText(etSimThirdInput.text.toString())
                            etSimThirdInput.setText(temp.toString())
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }

                    5 -> {
                        if(Integer.parseInt(etSimFifthInput.text.toString()) < Integer.parseInt(etSimFourthInput.text.toString())) {
                            temp = Integer.parseInt(etSimFifthInput.text.toString())
                            etSimFifthInput.setText(etSimFourthInput.text.toString())
                            etSimFourthInput.setText(temp.toString())
                            etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }

                    6 -> {
                        if(Integer.parseInt(etSimSixthInput.text.toString()) < Integer.parseInt(etSimFifthInput.text.toString())) {
                            temp = Integer.parseInt(etSimSixthInput.text.toString())
                            etSimSixthInput.setText(etSimFifthInput.text.toString())
                            etSimFifthInput.setText(temp.toString())
                            etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                        }else{
                            position++
                            location = position
                        }
                    }
                }
                btnCheckInsertionSort.text = "CHECK"
            }
            7 -> {
                when(location){
                    2 -> {
                        if(Integer.parseInt(etSimSecondInput.text.toString()) < Integer.parseInt(etSimFirstInput.text.toString())) {
                            temp = Integer.parseInt(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(etSimFirstInput.text.toString())
                            etSimFirstInput.setText(temp.toString())
                            etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location++
                            location = position
                            btnCheckInsertionSort.text = "CHECK"
                        }else{
                            position++
                            location = position
                            btnCheckInsertionSort.text = "FINISH"
                        }
                    }
                    3 -> {
                        if(Integer.parseInt(etSimThirdInput.text.toString()) < Integer.parseInt(etSimSecondInput.text.toString())) {
                            temp = Integer.parseInt(etSimThirdInput.text.toString())
                            etSimThirdInput.setText(etSimSecondInput.text.toString())
                            etSimSecondInput.setText(temp.toString())
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                            btnCheckInsertionSort.text = "CHECK"
                        }else{
                            position++
                            location = position
                            btnCheckInsertionSort.text = "FINISH"
                        }
                    }

                    4 -> {
                        if(Integer.parseInt(etSimFourthInput.text.toString()) < Integer.parseInt(etSimThirdInput.text.toString())) {
                            temp = Integer.parseInt(etSimFourthInput.text.toString())
                            etSimFourthInput.setText(etSimThirdInput.text.toString())
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            etSimThirdInput.setText(temp.toString())
                            location--
                            btnCheckInsertionSort.text = "CHECK"
                        }else{
                            position++
                            location = position
                            btnCheckInsertionSort.text = "FINISH"
                        }
                    }

                    5 -> {
                        if(Integer.parseInt(etSimFifthInput.text.toString()) < Integer.parseInt(etSimFourthInput.text.toString())) {
                            temp = Integer.parseInt(etSimFifthInput.text.toString())
                            etSimFifthInput.setText(etSimFourthInput.text.toString())
                            etSimFourthInput.setText(temp.toString())
                            etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                            btnCheckInsertionSort.text = "CHECK"
                        }else{
                            position++
                            location = position
                            btnCheckInsertionSort.text = "FINISH"
                        }
                    }

                    6 -> {
                        if(Integer.parseInt(etSimSixthInput.text.toString()) < Integer.parseInt(etSimFifthInput.text.toString())) {
                            temp = Integer.parseInt(etSimSixthInput.text.toString())
                            etSimSixthInput.setText(etSimFifthInput.text.toString())
                            etSimFifthInput.setText(temp.toString())
                            etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                            btnCheckInsertionSort.text = "CHECK"
                        }else{
                            position++
                            location = position
                            btnCheckInsertionSort.text = "FINISH"
                        }
                    }

                    7-> {
                        if(Integer.parseInt(etSimSeventhInput.text.toString()) < Integer.parseInt(etSimSixthInput.text.toString())) {
                            temp = Integer.parseInt(etSimSeventhInput.text.toString())
                            etSimSeventhInput.setText(etSimSixthInput.text.toString())
                            etSimSixthInput.setText(temp.toString())
                            etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                            etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                            location--
                            btnCheckInsertionSort.text = "CHECK"
                        }else{
                            position++
                            location = position
                            btnCheckInsertionSort.text = "FINISH"
                        }
                    }
                }

            }
        }

    }


    private fun inputCheck() : Boolean {
        if(etSimFirstInput.text.toString().trim().isEmpty() || etSimSecondInput.text.toString().trim().isEmpty() || etSimThirdInput.text.toString().trim().isEmpty() || etSimFourthInput.text.toString().trim().isEmpty()
            || etSimFifthInput.text.toString().trim().isEmpty() || etSimSixthInput.text.toString().trim().isEmpty() || etSimSeventhInput.text.toString().trim().isEmpty() || etSimFirstInput.text.toString() == "-" || etSimSecondInput.text.toString() == "-"
            || etSimThirdInput.text.toString() == "-" || etSimFourthInput.text.toString() == "-" || etSimFifthInput.text.toString() == "-" || etSimSixthInput.text.toString() == "-" || etSimSeventhInput.text.toString() == "-"
            || etSimFirstInput.text.toString() == "+" || etSimSecondInput.text.toString() == "+"
            || etSimThirdInput.text.toString() == "+" || etSimFourthInput.text.toString() == "+" || etSimFifthInput.text.toString() == "+" || etSimSixthInput.text.toString() == "+" || etSimSeventhInput.text.toString() == "+"){
            return true
        }
        return false
    }

    private fun checkArray(){
        when(location){
            1 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                btnCheckInsertionSort.text = "NEXT"
            }
            2 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                btnCheckInsertionSort.text = "NEXT"
            }
            3 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                btnCheckInsertionSort.text = "NEXT"
            }
            4 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                btnCheckInsertionSort.text = "NEXT"
            }
            5 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                btnCheckInsertionSort.text = "NEXT"
            }
            6 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                btnCheckInsertionSort.text = "NEXT"
            }
            7 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                btnCheckInsertionSort.text = "NEXT"
            }
        }
        when(position){
            1 -> {
                ivSimFirstIndexArrow.visibility = View.VISIBLE
                ivSimSecondIndexArrow.visibility = View.INVISIBLE
                ivSimThirdIndexArrow.visibility = View.INVISIBLE
                ivSimFourthIndexArrow.visibility = View.INVISIBLE
                ivSimFifthIndexArrow.visibility = View.INVISIBLE
                ivSimSixthIndexArrow.visibility = View.INVISIBLE
                ivSimSeventhIndexArrow.visibility = View.INVISIBLE
            }
            2 -> {
                ivSimFirstIndexArrow.visibility = View.INVISIBLE
                ivSimSecondIndexArrow.visibility = View.VISIBLE
                ivSimThirdIndexArrow.visibility = View.INVISIBLE
                ivSimFourthIndexArrow.visibility = View.INVISIBLE
                ivSimFifthIndexArrow.visibility = View.INVISIBLE
                ivSimSixthIndexArrow.visibility = View.INVISIBLE
                ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)

            }
            3 -> {
                ivSimFirstIndexArrow.visibility = View.INVISIBLE
                ivSimSecondIndexArrow.visibility = View.INVISIBLE
                ivSimThirdIndexArrow.visibility = View.VISIBLE
                ivSimFourthIndexArrow.visibility = View.INVISIBLE
                ivSimFifthIndexArrow.visibility = View.INVISIBLE
                ivSimSixthIndexArrow.visibility = View.INVISIBLE
                ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
            }
            4 -> {
                ivSimFirstIndexArrow.visibility = View.INVISIBLE
                ivSimSecondIndexArrow.visibility = View.INVISIBLE
                ivSimThirdIndexArrow.visibility = View.INVISIBLE
                ivSimFourthIndexArrow.visibility = View.VISIBLE
                ivSimFifthIndexArrow.visibility = View.INVISIBLE
                ivSimSixthIndexArrow.visibility = View.INVISIBLE
                ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
            }
            5 -> {
                ivSimFirstIndexArrow.visibility = View.INVISIBLE
                ivSimSecondIndexArrow.visibility = View.INVISIBLE
                ivSimThirdIndexArrow.visibility = View.INVISIBLE
                ivSimFourthIndexArrow.visibility = View.INVISIBLE
                ivSimFifthIndexArrow.visibility = View.VISIBLE
                ivSimSixthIndexArrow.visibility = View.INVISIBLE
                ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
            }
            6 -> {
                ivSimFirstIndexArrow.visibility = View.INVISIBLE
                ivSimSecondIndexArrow.visibility = View.INVISIBLE
                ivSimThirdIndexArrow.visibility = View.INVISIBLE
                ivSimFourthIndexArrow.visibility = View.INVISIBLE
                ivSimFifthIndexArrow.visibility = View.INVISIBLE
                ivSimSixthIndexArrow.visibility = View.VISIBLE
                ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
            }
            7 -> {
                ivSimFirstIndexArrow.visibility = View.INVISIBLE
                ivSimSecondIndexArrow.visibility = View.INVISIBLE
                ivSimThirdIndexArrow.visibility = View.INVISIBLE
                ivSimFourthIndexArrow.visibility = View.INVISIBLE
                ivSimFifthIndexArrow.visibility = View.INVISIBLE
                ivSimSixthIndexArrow.visibility = View.INVISIBLE
                ivSimSeventhIndexArrow.visibility = View.VISIBLE
            }
        }
    }

    private fun setDefaultBackground(){
        etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)

        ivSimFirstIndexArrow.visibility = View.INVISIBLE
        ivSimSecondIndexArrow.visibility = View.INVISIBLE
        ivSimThirdIndexArrow.visibility = View.INVISIBLE
        ivSimFourthIndexArrow.visibility = View.INVISIBLE
        ivSimFifthIndexArrow.visibility = View.INVISIBLE
        ivSimSixthIndexArrow.visibility = View.INVISIBLE
        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
    }

    private fun enableViews(){
        etSimFirstInput.setTypeface(null, Typeface.NORMAL)
        etSimSecondInput.setTypeface(null, Typeface.NORMAL)
        etSimThirdInput.setTypeface(null, Typeface.NORMAL)
        etSimFourthInput.setTypeface(null, Typeface.NORMAL)
        etSimFifthInput.setTypeface(null, Typeface.NORMAL)
        etSimSixthInput.setTypeface(null, Typeface.NORMAL)
        etSimSeventhInput.setTypeface(null, Typeface.NORMAL)

        etSimFirstInput.isEnabled = true
        etSimSecondInput.isEnabled = true
        etSimThirdInput.isEnabled = true
        etSimFourthInput.isEnabled = true
        etSimFifthInput.isEnabled = true
        etSimSixthInput.isEnabled = true
        etSimSeventhInput.isEnabled = true

        btnSimulateInsertion.isEnabled = true
        btnGenerateArrayInsertion.isEnabled = true
        btnCheckInsertionSort.isEnabled = false
    }

    private fun disableViews(){
        etSimFirstInput.setTypeface(null, Typeface.BOLD)
        etSimSecondInput.setTypeface(null, Typeface.BOLD)
        etSimThirdInput.setTypeface(null, Typeface.BOLD)
        etSimFourthInput.setTypeface(null, Typeface.BOLD)
        etSimFifthInput.setTypeface(null, Typeface.BOLD)
        etSimSixthInput.setTypeface(null, Typeface.BOLD)
        etSimSeventhInput.setTypeface(null, Typeface.BOLD)

        etSimFirstInput.isEnabled = false
        etSimSecondInput.isEnabled = false
        etSimThirdInput.isEnabled = false
        etSimFourthInput.isEnabled = false
        etSimFifthInput.isEnabled = false
        etSimSixthInput.isEnabled = false
        etSimSeventhInput.isEnabled = false


        btnSimulateInsertion.isEnabled = false
        btnGenerateArrayInsertion.isEnabled = false
        btnCheckInsertionSort.isEnabled = true
    }

    private fun generateNumbers(){
        var test:Boolean = true
        var indexone : Int = 0
        var indextwo : Int = 0
        var indexthree :Int = 0
        var indexfour : Int = 0
        var indexfive : Int = 0
        var indexsix : Int = 0
        var indexseven : Int = 0
        while(test){
            indexone = (1..99).random()
            indextwo = (1..99).random()
            indexthree = (1..99).random()
            indexfour = (1..99).random()
            indexfive = (1..99).random()
            indexsix = (1..99).random()
            indexseven = (1..99).random()
            if(indexone!=indextwo && indexone!=indexthree && indexone!=indexfour && indexone!=indexfive && indexone!=indexsix
                && indexone!=indexseven && indextwo!=indexthree && indextwo!=indexfour && indextwo!=indexfive && indextwo!=indexsix
                && indextwo!=indexseven && indexthree!=indexfour && indexthree!=indexfive && indexthree!=indexsix
                && indexthree!=indexseven && indexfour!=indexfive && indexfour!=indexsix && indexfour!=indexseven
                && indexfive!=indexsix && indexfive!=indexseven && indexsix!=indexseven){
                test = false
            }
        }

        etSimFirstInput.setText(indexone.toString())
        etSimSecondInput.setText(indextwo.toString())
        etSimThirdInput.setText(indexthree.toString())
        etSimFourthInput.setText(indexfour.toString())
        etSimFifthInput.setText(indexfive.toString())
        etSimSixthInput.setText(indexsix.toString())
        etSimSeventhInput.setText(indexseven.toString())
    }


}