package com.salam94.trinityiv.ui.main.contact

import com.salam94.trinityiv.model.Contact

interface ContactNavigator{
    fun onContactClicked(contact: Contact)
}