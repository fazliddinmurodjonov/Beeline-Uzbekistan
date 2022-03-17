package com.example.androidhardviewlesson7.models

import java.io.Serializable

class News :Serializable{
    var newsName:String?=null
    var newsImage:Int?=null
    var newsAbout:String?=null
    var newsDate:String?=null

    constructor(newsName: String?, newsImage: Int?, newsAbout: String?, newsDate: String?) {
        this.newsName = newsName
        this.newsImage = newsImage
        this.newsAbout = newsAbout
        this.newsDate = newsDate
    }
}