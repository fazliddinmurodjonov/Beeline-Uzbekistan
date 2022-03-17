package com.example.androidhardviewlesson7.models

import java.io.Serializable

class Internet :Serializable {
    var internetName:String?=null
    var internetTraffic:Int?=null
    var internetPayment:String?=null
    var internetImage:Int?=null
    var internetAbout:String?=null
    var internetJoinWithCode:String?=null

    constructor(
        internetName: String?,
        internetTraffic: Int?,
        internetPayment: String?,
        internetImage: Int?,
        internetAbout: String?,
        internetJoinWithCode: String?
    ) {
        this.internetName = internetName
        this.internetTraffic = internetTraffic
        this.internetPayment = internetPayment
        this.internetImage = internetImage
        this.internetAbout = internetAbout
        this.internetJoinWithCode = internetJoinWithCode
    }
}