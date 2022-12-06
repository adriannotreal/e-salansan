package com.adrianmarino.e_salansan

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_bubble_sort_simulation.*
import kotlinx.android.synthetic.main.activity_linear_search_simulation.*

class LinearSearchSimulationActivity : AppCompatActivity() {

    private lateinit var etSimFirstIndex : EditText
    private lateinit var etSimSecondIndex : EditText
    private lateinit var etSimThirdIndex : EditText
    private lateinit var etSimFourthIndex : EditText
    private lateinit var etSimFifthIndex : EditText
    private lateinit var etSimSixthIndex : EditText
    private lateinit var etSimSeventhIndex : EditText

    private lateinit var ivSimFirstIndexArrow : ImageView
    private lateinit var ivSimSecondIndexArrow : ImageView
    private lateinit var ivSimThirdIndexArrow : ImageView
    private lateinit var ivSimFourthIndexArrow : ImageView
    private lateinit var ivSimFifthIndexArrow : ImageView
    private lateinit var ivSimSixthIndexArrow : ImageView
    private lateinit var ivSimSeventhIndexArrow : ImageView

    private lateinit var etNumberToSearch : EditText
    private lateinit var etStatusLinear : EditText

    private var position = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_search_simulation)

        etSimFirstIndex = findViewById(R.id.et_sim_first_data_linear)
        etSimSecondIndex = findViewById(R.id.et_sim_second_data_linear)
        etSimThirdIndex = findViewById(R.id.et_sim_third_data_linear)
        etSimFourthIndex = findViewById(R.id.et_sim_fourth_data_linear)
        etSimFifthIndex = findViewById(R.id.et_sim_fifth_data_linear)
        etSimSixthIndex = findViewById(R.id.et_sim_sixth_data_linear)
        etSimSeventhIndex = findViewById(R.id.et_sim_seventh_data_linear)

        ivSimFirstIndexArrow = findViewById(R.id.et_sim_first_data_image_linear)
        ivSimSecondIndexArrow = findViewById(R.id.et_sim_second_data_image_linear)
        ivSimThirdIndexArrow = findViewById(R.id.et_sim_third_data_image_linear)
        ivSimFourthIndexArrow = findViewById(R.id.et_sim_fourth_data_image_linear)
        ivSimFifthIndexArrow = findViewById(R.id.et_sim_fifth_data_image_linear)
        ivSimSixthIndexArrow = findViewById(R.id.et_sim_sixth_data_image_linear)
        ivSimSeventhIndexArrow = findViewById(R.id.et_sim_seventh_data_image_linear)

        etNumberToSearch = findViewById(R.id.et_number_to_search_linear)
        etStatusLinear = findViewById(R.id.et_status_linear)

        hideImages()

        btnGenerateArray.setOnClickListener {
            generateNumbers()
        }

        btnCheckLinear.setOnClickListener {
            checkArray()
        }

        btnSimulateLinear.setOnClickListener {
            etNumberToSearch.isEnabled = false
            btnSimulateLinear.isEnabled = false
            btnGenerateArray.isEnabled = false
        }

    }

    private fun hideImages(){
        ivSimFirstIndexArrow.setImageResource(R.drawable.check)
        ivSimSecondIndexArrow.setImageResource(R.drawable.check)
        ivSimThirdIndexArrow.setImageResource(R.drawable.check)
        ivSimFourthIndexArrow.setImageResource(R.drawable.check)
        ivSimFifthIndexArrow.setImageResource(R.drawable.check)
        ivSimSixthIndexArrow.setImageResource(R.drawable.check)
        ivSimSeventhIndexArrow.setImageResource(R.drawable.check)

        ivSimFirstIndexArrow.visibility = View.INVISIBLE
        ivSimSecondIndexArrow.visibility = View.INVISIBLE
        ivSimThirdIndexArrow.visibility = View.INVISIBLE
        ivSimFourthIndexArrow.visibility = View.INVISIBLE
        ivSimFifthIndexArrow.visibility = View.INVISIBLE
        ivSimSixthIndexArrow.visibility = View.INVISIBLE
        ivSimSeventhIndexArrow.visibility = View.INVISIBLE

        etSimFirstIndex.setText("")
        etSimSecondIndex.setText("")
        etSimThirdIndex.setText("")
        etSimFourthIndex.setText("")
        etSimFifthIndex.setText("")
        etSimSixthIndex.setText("")
        etSimSeventhIndex.setText("")

        btnCheckLinear.text = "Start"

        etStatusLinear.visibility = View.INVISIBLE

        etNumberToSearch.isEnabled = true
        etNumberToSearch.setText("")

        btnSimulateLinear.isEnabled = true
        btnGenerateArray.isEnabled = true


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
        etSimFirstIndex.setText(indexone.toString())
        etSimSecondIndex.setText(indextwo.toString())
        etSimThirdIndex.setText(indexthree.toString())
        etSimFourthIndex.setText(indexfour.toString())
        etSimFifthIndex.setText(indexfive.toString())
        etSimSixthIndex.setText(indexsix.toString())
        etSimSeventhIndex.setText(indexseven.toString())
    }

    private fun checkArray(){
        if(btnCheckLinear.text=="Finish"){
            hideImages()
        }else{
            if(btnCheckLinear.text == "Check"){
                when(position){
                    1 ->{
                        if(Integer.parseInt(etSimFirstIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimFirstIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusLinear.setText("The number is present at index 1!")
                            etStatusLinear.visibility = View.VISIBLE
                            btnCheckLinear.text = "Finish"
                            position = 1
                        }else{
                            ivSimFirstIndexArrow.setImageResource(R.drawable.wronglinear)
                            position++
                            btnCheckLinear.text = "Next"
                        }
                    }
                    2 ->{
                        if(Integer.parseInt(etSimSecondIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimSecondIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusLinear.visibility = View.VISIBLE
                            etStatusLinear.setText("The number is present at index 2!")
                            btnCheckLinear.text = "Finish"
                            position = 1
                        }else{
                            ivSimSecondIndexArrow.setImageResource(R.drawable.wronglinear)
                            position++
                            btnCheckLinear.text = "Next"
                        }
                    }
                    3 ->{
                        if(Integer.parseInt(etSimThirdIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimThirdIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusLinear.visibility = View.VISIBLE
                            etStatusLinear.setText("The number is present at index 3!")
                            btnCheckLinear.text = "Finish"
                            position = 1
                        }else{
                            ivSimThirdIndexArrow.setImageResource(R.drawable.wronglinear)
                            position++
                            btnCheckLinear.text = "Next"
                        }
                    }
                    4 ->{
                        if(Integer.parseInt(etSimFourthIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimFourthIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusLinear.visibility = View.VISIBLE
                            etStatusLinear.setText("The number is present at index 4!")
                            btnCheckLinear.text = "Finish"
                            position = 1
                        }else{
                            ivSimFourthIndexArrow.setImageResource(R.drawable.wronglinear)
                            position++
                            btnCheckLinear.text = "Next"
                        }
                    }
                    5 ->{
                        if(Integer.parseInt(etSimFifthIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimFifthIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusLinear.visibility = View.VISIBLE
                            etStatusLinear.setText("The number is present at index 5!")
                            btnCheckLinear.text = "Finish"
                            position = 1
                        }else{
                            ivSimFifthIndexArrow.setImageResource(R.drawable.wronglinear)
                            position++
                            btnCheckLinear.text = "Next"
                        }
                    }
                    6 ->{
                        if(Integer.parseInt(etSimSixthIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimSixthIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusLinear.visibility = View.VISIBLE
                            etStatusLinear.setText("The number is present at index 6!")
                            btnCheckLinear.text = "Finish"
                            position = 1
                        }else{
                            ivSimSixthIndexArrow.setImageResource(R.drawable.wronglinear)
                            position++
                            btnCheckLinear.text = "Next"
                        }
                    }
                    7 ->{
                        if(Integer.parseInt(etSimSeventhIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimSeventhIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusLinear.visibility = View.VISIBLE
                            etStatusLinear.setText("The number is present at index 7!")
                            btnCheckLinear.text = "Finish"
                            position = 1
                        }else{
                            position++
                            btnCheckLinear.text = "Finish"
                            ivSimSeventhIndexArrow.setImageResource(R.drawable.wronglinear)
                            etStatusLinear.visibility = View.VISIBLE
                            etStatusLinear.setText("The number is not present in the array!")
                        }
                    }
                }
            }else{
                when(position){
                    1 ->{
                        ivSimFirstIndexArrow.visibility = View.VISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckLinear.text = "Check"
                    }
                    2 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.VISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckLinear.text = "Check"
                    }
                    3 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.VISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckLinear.text = "Check"
                    }
                    4 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.VISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckLinear.text = "Check"
                    }
                    5 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.VISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckLinear.text = "Check"
                    }
                    6 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.VISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckLinear.text = "Check"
                    }
                    7 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.VISIBLE
                        btnCheckLinear.text = "Check"
                    }
                }
            }
        }
    }
}