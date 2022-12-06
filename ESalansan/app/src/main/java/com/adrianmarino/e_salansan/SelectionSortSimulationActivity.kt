package com.adrianmarino.e_salansan

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_bubble_sort_simulation.*
import kotlinx.android.synthetic.main.activity_insertion_sort_simulation.*
import kotlinx.android.synthetic.main.activity_selection_sort_simulation.*

class SelectionSortSimulationActivity : AppCompatActivity() {

    private var sorted_index = 0
    private var compared_index = 2
    private var min_index = 1

    private lateinit var etSimFirstInput : EditText
    private lateinit var etSimSecondInput : EditText
    private lateinit var etSimThirdInput : EditText
    private lateinit var etSimFourthInput : EditText
    private lateinit var etSimFifthInput : EditText
    private lateinit var etSimSixthInput : EditText
    private lateinit var etSimSeventhInput : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_sort_simulation)

        etSimFirstInput = findViewById(R.id.et_sim_first_input_selection)
        etSimSecondInput = findViewById(R.id.et_sim_second_input_selection)
        etSimThirdInput = findViewById(R.id.et_sim_third_input_selection)
        etSimFourthInput = findViewById(R.id.et_sim_fourth_input_selection)
        etSimFifthInput = findViewById(R.id.et_sim_fifth_input_selection)
        etSimSixthInput = findViewById(R.id.et_sim_sixth_input_selection)
        etSimSeventhInput = findViewById(R.id.et_sim_seventh_input_selection)

        btnCheckSortSelection.text = "CHECK"

        btnSimulateSelection.setOnClickListener {
            if(inputCheck()){
                Toast.makeText(this, "Please fill up the whole array with numbers!", Toast.LENGTH_SHORT).show()
            }else{
                disableViews()
            }
        }

        btnCheckSortSelection.setOnClickListener {
            when(btnCheckSortSelection.text){
                "NEXT" -> {
                    simulateSelection()
                }
                "CHECK" -> {
                    checkArraySelection()
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
                    btnCheckSortSelection.text = "CHECK"
                    sorted_index = 0
                    compared_index = 2
                    min_index = 1
                }
            }
        }

        btnGenerateArraySelection.setOnClickListener {
            generateNumbers()
        }

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

        btnSimulateSelection.isEnabled = false
        btnGenerateArraySelection.isEnabled = false
        btnCheckSortSelection.isEnabled = true
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

        btnSimulateSelection.isEnabled = true
        btnGenerateArraySelection.isEnabled = true
        btnCheckSortSelection.isEnabled = false
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

    private fun simulateSelection(){

        when(sorted_index){
            0 ->{
                when(min_index){
                    1->{
                        when(compared_index){
                            2->{
                                if(Integer.parseInt(etSimFirstInput.text.toString()) > Integer.parseInt(etSimSecondInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            3->{
                                if(Integer.parseInt(etSimFirstInput.text.toString()) > Integer.parseInt(etSimThirdInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            4->{
                                if(Integer.parseInt(etSimFirstInput.text.toString()) > Integer.parseInt(etSimFourthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            5->{
                                if(Integer.parseInt(etSimFirstInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimFirstInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFirstInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        2->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSecondInput.text
                                            etSimSecondInput.text = temp
                                        }
                                        3->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        2->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSecondInput.text
                                            etSimSecondInput.text = temp
                                        }
                                        3->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    2->{
                        when(compared_index){
                            3->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimThirdInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            4->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimFourthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            5->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        2->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSecondInput.text
                                            etSimSecondInput.text = temp
                                        }
                                        3->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        2->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSecondInput.text
                                            etSimSecondInput.text = temp
                                        }
                                        3->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    3->{
                        when(compared_index){
                            4->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimFourthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            5->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        3->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    setDefaultBackground()
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        3->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    setDefaultBackground()
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    4->{
                        when(compared_index){
                            5->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        4->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        4->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    5->{
                        when(compared_index){
                            6->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){

                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        5->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    6->{
                        when(compared_index){
                            7->{
                                if(Integer.parseInt(etSimSixthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        6->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFirstInput.text
                                            etSimFirstInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 3
                                    min_index = 2
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                }

                btnCheckSortSelection.text = "CHECK"
            }
            1 -> {
                when(min_index){
                    2->{
                        when(compared_index){
                            3->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimThirdInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            4->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimFourthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            5->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimSecondInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        3->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        3->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    3->{
                        when(compared_index){
                            4->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimFourthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            5->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        3->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        3->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimThirdInput.text
                                            etSimThirdInput.text = temp
                                        }
                                        4->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    4->{
                        when(compared_index){
                            5->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        4->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        4->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    5->{
                        when(compared_index){
                            6->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        5->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        5->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    6->{
                        when(compared_index){
                            7->{
                                if(Integer.parseInt(etSimSixthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        6->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSecondInput.text
                                            etSimSecondInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 4
                                    min_index = 3
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                }

                btnCheckSortSelection.text = "CHECK"
            }
            2 -> {
                when(min_index){
                    3->{
                        when(compared_index){
                            4->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimFourthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            5->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimThirdInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){

                                        4->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 5
                                    min_index = 4
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        4->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 5
                                    min_index = 4
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    4->{
                        when(compared_index){
                            5->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        4->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 5
                                    min_index = 4
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        4->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFourthInput.text
                                            etSimFourthInput.text = temp
                                        }
                                        5->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 5
                                    min_index = 4
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    5->{
                        when(compared_index){
                            6->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        5->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 5
                                    min_index = 4
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        5->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 5
                                    min_index = 4
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    6->{
                        when(compared_index){
                            7->{
                                if(Integer.parseInt(etSimSixthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        6->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 5
                                    min_index = 4
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        6->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimThirdInput.text
                                            etSimThirdInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 5
                                    min_index = 4
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                }

                btnCheckSortSelection.text = "CHECK"
            }
            3 -> {
                when(min_index){
                    4->{
                        when(compared_index){
                            5->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimFifthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            6->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFourthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        5->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 6
                                    min_index = 5
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        5->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 6
                                    min_index = 5
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    5->{
                        when(compared_index){
                            6->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        5->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 6
                                    min_index = 5
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        5->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimFifthInput.text
                                            etSimFifthInput.text = temp
                                        }
                                        6->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFourthInput.text
                                            etSimFourthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 6
                                    min_index = 5
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    6->{
                        when(compared_index){
                            7->{
                                if(Integer.parseInt(etSimSixthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        6->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 6
                                    min_index = 5
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        6->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 6
                                    min_index = 5
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                }

                btnCheckSortSelection.text = "CHECK"
            }
            4 -> {
                when(min_index){
                    5->{
                        when(compared_index){
                            6->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSixthInput.text.toString())){
                                    min_index = compared_index
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    compared_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                            7->{
                                if(Integer.parseInt(etSimFifthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        6->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 7
                                    min_index = 6
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        6->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 7
                                    min_index = 6
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                    6->{
                        when(compared_index){
                            7->{
                                if(Integer.parseInt(etSimSixthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        6->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    compared_index = 7
                                    min_index = 6
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        6->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimFifthInput.text
                                            etSimFifthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    compared_index = 7
                                    min_index = 6
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                            }
                        }
                    }
                }

                btnCheckSortSelection.text = "CHECK"
            }
            5 -> {
                when(min_index){
                    6->{
                        when(compared_index){
                            7->{
                                if(Integer.parseInt(etSimSixthInput.text.toString()) > Integer.parseInt(etSimSeventhInput.text.toString())){
                                    min_index = compared_index
                                    when(min_index){
                                        6->{
                                            val temp = etSimSixthInput.text
                                            etSimSixthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSixthInput.text
                                            etSimSixthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index ++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }else{
                                    when(min_index){
                                        6->{
                                            val temp = etSimSixthInput.text
                                            etSimSixthInput.text = etSimSixthInput.text
                                            etSimSixthInput.text = temp
                                        }
                                        7->{
                                            val temp = etSimSixthInput.text
                                            etSimSixthInput.text = etSimSeventhInput.text
                                            etSimSeventhInput.text = temp
                                        }
                                    }
                                    sorted_index++
                                    setDefaultBackground()
                                    etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                    etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.unsorted_border_bg)
                                }
                                btnCheckSortSelection.text = "FINISH"
                            }
                        }
                    }
                }
            }
        }

    }

    private fun checkArraySelection(){
        when(min_index){
            1 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
            2 ->{
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
            3 ->{
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
            4 ->{
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
            5 ->{
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
            6 ->{
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
            7 ->{
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border_bg)
            }
        }
        when(compared_index){
            1 ->{
                etSimFirstInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
            2 ->{
                etSimSecondInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
            3 ->{
                etSimThirdInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
            4 ->{
                etSimFourthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
            5 ->{
                etSimFifthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
            6 ->{
                etSimSixthInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
            7 ->{
                etSimSeventhInput.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border_bg)
            }
        }
        btnCheckSortSelection.text = "NEXT"
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


}