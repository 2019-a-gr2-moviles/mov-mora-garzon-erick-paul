package com.example.examen

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Actor (
    var nombre:String,
    var apellido:String,
    var fechaNacimiento:Date,
    var numeroPeliculas:Int,
    var retirado:Boolean):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readSerializable() as Date,
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(apellido)
        parcel.writeSerializable(fechaNacimiento)
        parcel.writeInt(numeroPeliculas)
        parcel.writeByte(if (retirado) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Actor> {
        override fun createFromParcel(parcel: Parcel): Actor {
            return Actor(parcel)
        }

        override fun newArray(size: Int): Array<Actor?> {
            return arrayOfNulls(size)
        }
    }

}