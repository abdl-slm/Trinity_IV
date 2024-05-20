package com.salam94.trinityiv.login

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.salam94.trinityiv.model.Contact
import com.salam94.trinityiv.util.SharedPreference
import com.salam94.trinityiv.util.Util

class LoginViewModel: ViewModel() {

    private lateinit var loginNavigator: LoginNavigator

    private fun getContactList(context: Context): List<Contact> {

        val jsonFileString = Util().getJsonDataFromAsset(context, "data.json")

        val gson = Gson()
        val listPersonType = object : TypeToken<List<Contact>>() {}.type

        return gson.fromJson(jsonFileString, listPersonType)
    }

    fun setNavigator(loginNavigator: LoginNavigator){
        this.loginNavigator = loginNavigator
    }


    //Not checking for password, as long as email matches
    fun handleLogin(activity: LoginActivity, context: Context, fullName: String){

        val listOfContact = getContactList(context)

        for (contact in listOfContact){
            val currentFullName = contact.firstName + " " + contact.lastName
            if(fullName == currentFullName){
                saveLoginInfo(activity, contact)
                loginNavigator.navigateWhenSuccess()
                return
            }
        }

        loginNavigator.navigateWhenFail()
    }

    private fun saveLoginInfo(activity: LoginActivity, contact: Contact){
        SharedPreference().saveValue(activity, SharedPreference().ID, contact.id ?: "")
        SharedPreference().saveValue(activity, SharedPreference().DOB, contact.dob ?: "")
        SharedPreference().saveValue(activity, SharedPreference().FIRST_NAME, contact.firstName ?: "")
        SharedPreference().saveValue(activity, SharedPreference().LAST_NAME, contact.lastName ?: "")
        SharedPreference().saveValue(activity, SharedPreference().EMAIL, contact.email ?: "")
    }

}