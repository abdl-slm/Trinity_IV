package com.salam94.trinityiv.ui.main.contact

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.salam94.trinityiv.R
import com.salam94.trinityiv.model.Contact
import com.salam94.trinityiv.util.Util
import com.salam94.trinityiv.util.inflate

class ContactAdapter(private val contact: List<Contact>, val contactNavigator: ContactNavigator): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val inflatedView = parent.inflate(R.layout.item_contact, false)
        return ContactHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return contact.size
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {

        val itemSet = contact[position]
        holder.bindContact(itemSet)
    }


    inner class ContactHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private val textContactName = v.findViewById<TextView>(R.id.txtContactName)
        private val textAbbr = v.findViewById<TextView>(R.id.txtAbbrName)
        private var contact: Contact? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            contact?.let { contactNavigator.onContactClicked(it) }
        }

        fun bindContact(contact: Contact) {
            this.contact = contact
            textContactName.text = contact.firstName + " " + contact.lastName
            textAbbr.text = contact.lastName?.let { contact.firstName?.let { it1 -> Util().nameAbbreviator(it1, it) } }

        }
    }

}