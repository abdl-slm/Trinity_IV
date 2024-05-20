package com.salam94.trinityiv.util

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class SharedPreference {

    val ID = "ID"
    val FIRST_NAME = "FIRST_NAME"
    val LAST_NAME = "LAST_NAME"
    val DOB = "DOB"
    val EMAIL = "EMAIL"

    fun saveValue(activity: Activity, key: String, value: String){
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun retrieveValue(activity: Activity, key: String): String? {
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE) ?: return ""
        return sharedPref.getString(key, "")
    }
}