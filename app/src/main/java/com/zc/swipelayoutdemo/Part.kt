package com.zc.swipelayoutdemo

import android.os.Parcel
import android.os.Parcelable

data class Part(
    var name: String?,
    var price: Float? = 0f
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Float::class.java.classLoader) as? Float
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Part> {
        override fun createFromParcel(parcel: Parcel): Part {
            return Part(parcel)
        }

        override fun newArray(size: Int): Array<Part?> {
            return arrayOfNulls(size)
        }
    }
}
