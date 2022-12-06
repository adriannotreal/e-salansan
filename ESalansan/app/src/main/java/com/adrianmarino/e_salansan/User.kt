package com.adrianmarino.e_salansan

class User {
    constructor(){

    }
    var id : Int = 0
    var username : String = ""
    var password : String = ""
    var challenge1_high_score : Int = 0
    var challenge2_high_score : Int = 0
    var challenge3_high_score : Int = 0
    var challenge4_high_score : Int = 0
    var challenge5_high_score : Int = 0
    var challenge6_high_score : Int = 0

    constructor(username: String?, password: String){
        this.username = username!!
        this.password = password
    }
}