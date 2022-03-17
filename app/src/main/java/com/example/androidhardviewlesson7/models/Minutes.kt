package com.example.androidhardviewlesson7.models

import java.io.Serializable

class Minutes :Serializable{
    var minutesName: String? = null
    var minutesInternet: Int? = null
    var minutesMinute: Int? = null
    var minutesPayment: String? = null
    var minutesImage: Int? = null
    var minutesAbout: String? = null
    var minutesJoinWithCode: String? = null

    constructor(
        minutesName: String?,
        minutesInternet: Int?,
        minutesMinute: Int?,
        minutesPayment: String?,
        minutesImage: Int?,
        minutesAbout: String?,
        minutesJoinWithCode: String?
    ) {
        this.minutesName = minutesName
        this.minutesInternet = minutesInternet
        this.minutesMinute = minutesMinute
        this.minutesPayment = minutesPayment
        this.minutesImage = minutesImage
        this.minutesAbout = minutesAbout
        this.minutesJoinWithCode = minutesJoinWithCode
    }
}