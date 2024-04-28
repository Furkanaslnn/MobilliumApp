package com.orangehat.mobillium_project

class User {

    var id:Int = 0
    var username:String = ""
    var password:String = ""

    constructor(username:String, password:String){
        this.username = username
        this.password = password
    }
    // veri okuyabilmek için boş const
    constructor(){

    }
}