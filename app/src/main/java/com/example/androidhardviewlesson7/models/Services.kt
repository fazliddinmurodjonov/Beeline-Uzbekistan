package com.example.androidhardviewlesson7.models

import java.io.Serializable

class Services :Serializable {
    var serviceName: String? = null
    var serviceAbout: String? = null
    var servicePriceDay: String? = null
    var servicePriceMonth: String? = null
    var serviceImage: Int? = null

    constructor(
        serviceName: String?,
        serviceAbout: String?,
        servicePriceDay: String?,
        servicePriceMonth: String?,
        serviceImage: Int?
    ) {
        this.serviceName = serviceName
        this.serviceAbout = serviceAbout
        this.servicePriceDay = servicePriceDay
        this.servicePriceMonth = servicePriceMonth
        this.serviceImage = serviceImage
    }
}