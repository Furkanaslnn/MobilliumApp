package com.orangehat.mobillium_project

class Passwords {
    var id: Int = 0
    var passwordName: String = ""
    var password: String = ""

    constructor(passwordName: String, password: String) {
        this.passwordName = passwordName
        this.password = password
    }

    constructor() {

    }
}