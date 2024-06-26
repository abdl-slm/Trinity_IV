package com.salam94.trinityiv.model

import android.os.Parcel
import android.os.Parcelable


//"id": "5c8a80f52dfee238898d64cf",
//"firstName": "Phoebe",
//"lastName": "Monroe",
//"email": "phoebemonroe@furnafix.com",
//"dob": "3/2/1982"
data class Contact(val id: String?, val firstName: String?, val lastName: String?, val email: String?, val dob: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(email)
        parcel.writeString(dob)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}
