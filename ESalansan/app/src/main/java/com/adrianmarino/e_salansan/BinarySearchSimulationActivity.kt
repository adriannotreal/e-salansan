package com.adrianmarino.e_salansan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_binary_search_simulation.*

class BinarySearchSimulationActivity : AppCompatActivity() {

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
    private lateinit var etStatusBinary : EditText

    private var position = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_binary_search_simulation)

        etSimFirstIndex = findViewById(R.id.et_sim_first_data_binary)
        etSimSecondIndex = findViewById(R.id.et_sim_second_data_binary)
        etSimThirdIndex = findViewById(R.id.et_sim_third_data_binary)
        etSimFourthIndex = findViewById(R.id.et_sim_fourth_data_binary)
        etSimFifthIndex = findViewById(R.id.et_sim_fifth_data_binary)
        etSimSixthIndex = findViewById(R.id.et_sim_sixth_data_binary)
        etSimSeventhIndex = findViewById(R.id.et_sim_seventh_data_binary)

        ivSimFirstIndexArrow = findViewById(R.id.et_sim_first_data_image_binary)
        ivSimSecondIndexArrow = findViewById(R.id.et_sim_second_data_image_binary)
        ivSimThirdIndexArrow = findViewById(R.id.et_sim_third_data_image_binary)
        ivSimFourthIndexArrow = findViewById(R.id.et_sim_fourth_data_image_binary)
        ivSimFifthIndexArrow = findViewById(R.id.et_sim_fifth_data_image_binary)
        ivSimSixthIndexArrow = findViewById(R.id.et_sim_sixth_data_image_binary)
        ivSimSeventhIndexArrow = findViewById(R.id.et_sim_seventh_data_image_binary)

        etNumberToSearch = findViewById(R.id.et_number_to_search_binary)
        etStatusBinary = findViewById(R.id.et_status_binary)

        hideImages()

        btnGenerateArrayBinary.setOnClickListener {
            generateNumbers()
        }

        btnSimulateBinary.setOnClickListener{
            etNumberToSearch.isEnabled = false
            btnSimulateBinary.isEnabled = false
            btnGenerateArrayBinary.isEnabled = false
        }

        btnCheckBinary.setOnClickListener {
            checkArray()
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

        etSimFirstIndex.visibility = View.VISIBLE
        etSimSecondIndex.visibility = View.VISIBLE
        etSimThirdIndex.visibility = View.VISIBLE
        etSimFourthIndex.visibility = View.VISIBLE
        etSimFifthIndex.visibility = View.VISIBLE
        etSimSixthIndex.visibility = View.VISIBLE
        etSimSeventhIndex.visibility = View.VISIBLE

        etSimFirstIndex.setText("")
        etSimSecondIndex.setText("")
        etSimThirdIndex.setText("")
        etSimFourthIndex.setText("")
        etSimFifthIndex.setText("")
        etSimSixthIndex.setText("")
        etSimSeventhIndex.setText("")

        btnCheckBinary.text = "Start"

        etStatusBinary.visibility = View.INVISIBLE

        etNumberToSearch.isEnabled = true
        etNumberToSearch.setText("")

        btnSimulateBinary.isEnabled = true
        btnGenerateArrayBinary.isEnabled = true
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
        var arrayintgen = intArrayOf(0,0,0,0,0,0,0)
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

        arrayintgen[0] = indexone
        arrayintgen[1] = indextwo
        arrayintgen[2] = indexthree
        arrayintgen[3] = indexfour
        arrayintgen[4] = indexfive
        arrayintgen[5] = indexsix
        arrayintgen[6] = indexseven

        var swap = true
        while(swap){
            swap = false
            for(i in 0 until arrayintgen.size-1){
                if(arrayintgen[i] > arrayintgen[i+1]){
                    val temp = arrayintgen[i]
                    arrayintgen[i] = arrayintgen[i+1]
                    arrayintgen[i + 1] = temp
                    swap = true
                }
            }
        }

        etSimFirstIndex.setText(arrayintgen[0].toString())
        etSimSecondIndex.setText(arrayintgen[1].toString())
        etSimThirdIndex.setText(arrayintgen[2].toString())
        etSimFourthIndex.setText(arrayintgen[3].toString())
        etSimFifthIndex.setText(arrayintgen[4].toString())
        etSimSixthIndex.setText(arrayintgen[5].toString())
        etSimSeventhIndex.setText(arrayintgen[6].toString())
    }

    private fun checkArray(){
        if(btnCheckBinary.text=="Finish"){
            hideImages()
        }else{
            if(btnCheckBinary.text == "Check"){
                when(position){
                    1 ->{
                        if(Integer.parseInt(etSimFirstIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimFirstIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is present at index 1!")
                            btnCheckBinary.text = "Finish"
                            position = 4
                        }else{
                            position=4
                            btnCheckBinary.text = "Finish"
                            ivSimFirstIndexArrow.setImageResource(R.drawable.wronglinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is not present in the array!")
                        }
                    }
                    2 ->{
                        if(Integer.parseInt(etSimSecondIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimSecondIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is present at index 2!")
                            btnCheckBinary.text = "Finish"
                            position = 4
                        }else{
                            ivSimSecondIndexArrow.setImageResource(R.drawable.wronglinear)
                            btnCheckBinary.text = "Next"
                            if(Integer.parseInt(etSimSecondIndex.text.toString())>Integer.parseInt(etNumberToSearch.text.toString())){
                                position = 1
                            }else{
                                position = 3
                            }
                        }
                    }
                    3 ->{
                        if(Integer.parseInt(etSimThirdIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimThirdIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is present at index 3!")
                            btnCheckBinary.text = "Finish"
                            position = 4
                        }else{
                            position = 4
                            btnCheckBinary.text = "Finish"
                            ivSimThirdIndexArrow.setImageResource(R.drawable.wronglinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is not present in the array!")
                        }
                    }
                    4 ->{
                        if(Integer.parseInt(etSimFourthIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimFourthIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is present at index 4!")
                            btnCheckBinary.text = "Finish"
                            position = 4
                        }else{
                            ivSimFourthIndexArrow.setImageResource(R.drawable.wronglinear)
                            btnCheckBinary.text = "Next"
                            if(Integer.parseInt(etSimFourthIndex.text.toString())>Integer.parseInt(etNumberToSearch.text.toString())){
                                position = 2
                            }else{
                                position = 6
                            }
                        }
                    }
                    5 ->{
                        if(Integer.parseInt(etSimFifthIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimFifthIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is present at index 5!")
                            btnCheckBinary.text = "Finish"
                            position = 4
                        }else{
                            position = 4
                            btnCheckBinary.text = "Finish"
                            ivSimFifthIndexArrow.setImageResource(R.drawable.wronglinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is not present in the array!")
                        }
                    }
                    6 ->{
                        if(Integer.parseInt(etSimSixthIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimSixthIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is present at index 6!")
                            btnCheckBinary.text = "Finish"
                            position = 4
                        }else{
                            ivSimSixthIndexArrow.setImageResource(R.drawable.wronglinear)
                            btnCheckBinary.text = "Next"
                            if(Integer.parseInt(etSimSixthIndex.text.toString())>Integer.parseInt(etNumberToSearch.text.toString())){
                                position = 5
                            }else{
                                position = 7
                            }
                        }
                    }
                    7 ->{
                        if(Integer.parseInt(etSimSeventhIndex.text.toString())==Integer.parseInt(etNumberToSearch.text.toString())){
                            ivSimSeventhIndexArrow.setImageResource(R.drawable.truelinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is present at index 7!")
                            btnCheckBinary.text = "Finish"
                            position = 4
                        }else{
                            position = 4
                            btnCheckBinary.text = "Finish"
                            ivSimSeventhIndexArrow.setImageResource(R.drawable.wronglinear)
                            etStatusBinary.visibility = View.VISIBLE
                            etStatusBinary.setText("The number is not present in the array!")
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
                        btnCheckBinary.text = "Check"
                        etSimSecondIndex.visibility = View.INVISIBLE
                        etSimThirdIndex.visibility = View.INVISIBLE
                    }
                    2 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.VISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckBinary.text = "Check"
                        etSimFourthIndex.visibility = View.INVISIBLE
                        etSimFifthIndex.visibility = View.INVISIBLE
                        etSimSixthIndex.visibility = View.INVISIBLE
                        etSimSeventhIndex.visibility = View.INVISIBLE

                    }
                    3 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.VISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckBinary.text = "Check"
                        etSimFirstIndex.visibility = View.INVISIBLE
                        etSimSecondIndex.visibility = View.INVISIBLE
                    }
                    4 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.VISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckBinary.text = "Check"
                    }
                    5 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.VISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckBinary.text = "Check"
                        etSimSixthIndex.visibility = View.INVISIBLE
                        etSimSeventhIndex.visibility = View.INVISIBLE
                    }
                    6 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.VISIBLE
                        ivSimSeventhIndexArrow.visibility = View.INVISIBLE
                        btnCheckBinary.text = "Check"
                        etSimFourthIndex.visibility = View.INVISIBLE
                        etSimFirstIndex.visibility = View.INVISIBLE
                        etSimSecondIndex.visibility = View.INVISIBLE
                        etSimThirdIndex.visibility = View.INVISIBLE
                    }
                    7 ->{
                        ivSimFirstIndexArrow.visibility = View.INVISIBLE
                        ivSimSecondIndexArrow.visibility = View.INVISIBLE
                        ivSimThirdIndexArrow.visibility = View.INVISIBLE
                        ivSimFourthIndexArrow.visibility = View.INVISIBLE
                        ivSimFifthIndexArrow.visibility = View.INVISIBLE
                        ivSimSixthIndexArrow.visibility = View.INVISIBLE
                        ivSimSeventhIndexArrow.visibility = View.VISIBLE
                        btnCheckBinary.text = "Check"
                        etSimSixthIndex.visibility = View.INVISIBLE
                        etSimFifthIndex.visibility = View.INVISIBLE
                    }
                }
            }
        }
    }

}