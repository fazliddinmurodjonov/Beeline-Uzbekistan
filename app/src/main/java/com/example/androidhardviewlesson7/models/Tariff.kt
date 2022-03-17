package com.example.androidhardviewlesson7.models

import java.io.Serializable

class Tariff : Serializable {
    var tariffName: String? = null
    var tariffImage: Int? = null
    var tariffPayment: String? = null
    var tariffOutCall: String? = null
    var tariffInternet: String? = null
    var tariffSMS: String? = null
    var tariffAbout: String? = null
    var tariffJoinWithCode: String? = null

    constructor(
        tariffName: String?,
        tariffImage: Int?,
        tariffPayment: String?,
        tariffOutCall: String?,
        tariffInternet: String?,
        tariffSMS: String?,
        tariffAbout: String?,
        tariffJoinWithCode: String?
    ) {
        this.tariffName = tariffName
        this.tariffImage = tariffImage
        this.tariffPayment = tariffPayment
        this.tariffOutCall = tariffOutCall
        this.tariffInternet = tariffInternet
        this.tariffSMS = tariffSMS
        this.tariffAbout = tariffAbout
        this.tariffJoinWithCode = tariffJoinWithCode
    }
}