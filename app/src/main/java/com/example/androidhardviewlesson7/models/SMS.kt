package com.example.androidhardviewlesson7.models

import java.io.Serializable

class SMS:Serializable {
    var smsName: String? = null
    var smsPayment: String? = null
    var smsCount: String? = null
    var smsImage: Int? = null
    var smsAbout: String? = null
    var smsJoinWithCode: String? = null

    constructor(
        smsName: String?,
        smsPayment: String?,
        smsCount: String?,
        smsImage: Int?,
        smsAbout: String?,
        smsJoinWithCode: String?
    ) {
        this.smsName = smsName
        this.smsPayment = smsPayment
        this.smsCount = smsCount
        this.smsImage = smsImage
        this.smsAbout = smsAbout
        this.smsJoinWithCode = smsJoinWithCode
    }
}