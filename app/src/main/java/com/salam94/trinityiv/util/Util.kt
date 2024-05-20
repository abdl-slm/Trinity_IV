package com.salam94.trinityiv.util

import android.content.Context
import java.io.IOException

class Util {

    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }


    fun nameAbbreviator(firstName: String, lastName: String): String{
        return (firstName.first() + "" +  lastName.first())
    }
}