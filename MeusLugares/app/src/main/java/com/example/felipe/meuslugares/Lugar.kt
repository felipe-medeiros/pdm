package com.example.felipe.meuslugares

import android.graphics.Bitmap
import android.location.Location
import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by felipe on 29/11/17.
 */

class Lugar(var nome: String, var desc: String, var foto: Bitmap, var local: Location?, var data: Date): Parcelable {

    constructor(source: Parcel): this(
        source.readString(),
        source.readString(),
        source.readParcelable<Bitmap>(Bitmap::class.java.classLoader),
        source.readParcelable<Location>(Location::class.java.classLoader),
        source.readSerializable() as Date
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(desc)
        parcel.writeParcelable(foto, flags)
        parcel.writeParcelable(local, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return this.nome
    }

    companion object CREATOR : Parcelable.Creator<Lugar> {
        override fun createFromParcel(parcel: Parcel): Lugar {
            return Lugar(parcel)
        }

        override fun newArray(size: Int): Array<Lugar?> {
            return arrayOfNulls(size)
        }
    }
}