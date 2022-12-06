package com.adrianmarino.e_salansan

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_bubble_sort_simulation.*
import kotlinx.android.synthetic.main.activity_insertion_sort_simulation.*
import kotlinx.android.synthetic.main.activity_selection_sort_simulation.*
import java.util.*

class BubbleSortSimulationActivity : AppCompatActivity() {

    private var highest_index = 7
    private var sorting_start = 1

    private lateinit var etSimFirstInput : EditText
    private lateinit var etSimSecondInput : EditText
    private lateinit var etSimThirdInput : EditText
    private lateinit var etSimFourthInput : EditText
    private lateinit var etSimFifthInput : EditText
    private lateinit var etSimSixthInput : EditText
    private lateinit var etSimSeventhInput : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bubble_sort_simulation)

        etSimFirstInput = findViewById(R.id.et_sim_first_input)
        etSimSecondInput = findViewById(R.id.et_sim_second_input)
        etSimThirdInput = findViewById(R.id.et_sim_third_input)
        etSimFourthInput = findViewById(R.id.et_sim_fourth_input)
        etSimFifthInput = findViewById(R.id.et_sim_fifth_input)
        etSimSixthInput = findViewById(R.id.et_sim_sixth_input)
        etSimSeventhInput = findViewById(R.id.et_sim_seventh_input)

        btnCheckSort.text = "CHECK"

        btnCheckSort.isEnabled = false

        btnSimulateBubble.setOnClickListener {
            if(inputCheck()){
                Toast.makeText(this, "Please fill up the whole array with numbers!", Toast.LENGTH_SHORT).show()
            }else{
                disableViews()
            }

        }
        btnCheckSort.setOnClickListener {
            when(btnCheckSort.text){
                "NEXT" -> {
                    simulateBubble()
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
                    btnCheckSort.text = "CHECK"
                    highest_index = 7
                    sorting_start = 1
                }
            }
        }

        btnGenerateArrayBubble.setOnClickListener {
            generateNumbers()
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

        btnSimulateBubble.isEnabled = false
        btnGenerateArrayBubble.isEnabled = false
        btnCheckSort.isEnabled = true
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

        btnSimulateBubble.isEnabled = true
        btnGenerateArrayBubble.isEnabled = true
        btnCheckSort.isEnabled = false
    }

    private fun setDefaultBackground(){
        etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
        etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
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


    private fun simulateBubble(){
        if(highest_index != 1){
            when(sorting_start){
                1 ->{
                    if (Integer.parseInt(etSimFirstInput.text.toString())>Integer.parseInt(etSimSecondInput.text.toString())){
                        val temp = etSimFirstInput.text
                        etSimFirstInput.text = etSimSecondInput.text
                        etSimSecondInput.text = temp
                        etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            highest_index --
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            if(highest_index == 1){
                                btnCheckSort.text= "FINISH"
                            }
                        }

                    }else{
                        etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            highest_index --
                            etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            if(highest_index == 1){
                                btnCheckSort.text= "FINISH"
                            }
                        }
                    }
                    btnCheckSort.text = "CHECK"
                    if(highest_index == 1){
                        btnCheckSort.text= "FINISH"
                    }
                }
                2 ->{
                    if (Integer.parseInt(etSimSecondInput.text.toString())>Integer.parseInt(etSimThirdInput.text.toString())){
                        val temp = etSimSecondInput.text
                        etSimSecondInput.text = etSimThirdInput.text
                        etSimThirdInput.text = temp
                        etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            highest_index --
                            sorting_start = 1
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                        }
                    }else{
                        etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            highest_index --
                            sorting_start = 1
                        }
                    }
                    btnCheckSort.text = "CHECK"
                }
                3 ->{
                    if (Integer.parseInt(etSimThirdInput.text.toString())>Integer.parseInt(etSimFourthInput.text.toString())){
                        val temp = etSimThirdInput.text
                        etSimThirdInput.text = etSimFourthInput.text
                        etSimFourthInput.text = temp
                        etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            highest_index --
                            sorting_start = 1
                        }
                    }else{
                        etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            highest_index --
                            sorting_start = 1
                        }
                    }
                    btnCheckSort.text = "CHECK"
                }
                4 ->{
                    if (Integer.parseInt(etSimFourthInput.text.toString())>Integer.parseInt(etSimFifthInput.text.toString())){
                        val temp = etSimFourthInput.text
                        etSimFourthInput.text = etSimFifthInput.text
                        etSimFifthInput.text = temp
                        etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            highest_index --
                            sorting_start = 1
                        }
                    }else{
                        etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            highest_index --
                            sorting_start = 1
                        }
                    }
                    btnCheckSort.text = "CHECK"
                }
                5 ->{
                    if (Integer.parseInt(etSimFifthInput.text.toString())>Integer.parseInt(etSimSixthInput.text.toString())){
                        val temp = etSimFifthInput.text
                        etSimFifthInput.text = etSimSixthInput.text
                        etSimSixthInput.text = temp
                        etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            highest_index --
                            sorting_start = 1
                        }
                    }else{
                        etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            highest_index --
                            sorting_start = 1
                        }
                    }
                    btnCheckSort.text = "CHECK"
                }
                6 ->{
                    if (Integer.parseInt(etSimSixthInput.text.toString())>Integer.parseInt(etSimSeventhInput.text.toString())){
                        val temp = etSimSixthInput.text
                        etSimSixthInput.text = etSimSeventhInput.text
                        etSimSeventhInput.text = temp
                        etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.sim_input_border_bg)
                        etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                        sorting_start++
                        if(sorting_start == highest_index){
                            etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            highest_index --
                            sorting_start = 1
                        }
                    }else{
                        sorting_start++
                        if(sorting_start == highest_index){
                            etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.sorted_border_bg)
                            highest_index --
                            sorting_start = 1
                        }
                    }
                    btnCheckSort.text = "CHECK"
                }
            }
        }
    }

    private fun checkArray(){
        when(sorting_start){
            1 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                btnCheckSort.text = "NEXT"
                }
            2 ->{
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                btnCheckSort.text = "NEXT"
            }
            3 ->{
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                btnCheckSort.text = "NEXT"
            }
            4 ->{
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                btnCheckSort.text = "NEXT"
            }
            5 ->{
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                btnCheckSort.text = "NEXT"
            }
            6 ->{
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
                btnCheckSort.text = "NEXT"
            }
        }
    }



}