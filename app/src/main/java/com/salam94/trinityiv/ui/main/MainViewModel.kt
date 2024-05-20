package com.salam94.trinityiv.ui.main

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.salam94.trinityiv.model.Contact
import com.salam94.trinityiv.util.Util

class MainViewModel : ViewModel() {
    //Implement logic here

    fun getContactList(context: Context): List<Contact> {

        val jsonFileString = Util().getJsonDataFromAsset(context, "data.json")

        val gson = Gson()
        val listPersonType = object : TypeToken<List<Contact>>() {}.type

        return gson.fromJson(jsonFileString, listPersonType)
    }
}