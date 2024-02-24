package com.example.dodoapp

import java.io.Serializable

data class DoDoItem(
    val type:ItemType,
    val id:Int,
    val name:String,
    val description:String,
    val imgSource:Int,
    val price:Int):Serializable
