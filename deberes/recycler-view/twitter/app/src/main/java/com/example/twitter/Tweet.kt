package com.example.twitter

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Tweet(
    var idUsuario: Int,
    var autor: String,
    var nombreDeUsuario: String,
    var tiempo: String,
    var contenido: String,
    var numComentarios: Int,
    var numRe: Int,
    var numMeGusta: Int/*,
    var fecha: String*/

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()/*,
        parcel.readString()*/

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idUsuario)
        parcel.writeString(autor)
        parcel.writeString(nombreDeUsuario)
        parcel.writeString(tiempo)
        parcel.writeString(contenido)
        parcel.writeInt(numComentarios)
        parcel.writeInt(numRe)
        parcel.writeInt(numMeGusta)
        //parcel.writeString(fecha)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<Tweet> {
        override fun createFromParcel(parcel: Parcel): Tweet {
            return Tweet(parcel)
        }

        override fun newArray(size: Int): Array<Tweet?> {
            return arrayOfNulls(size)
        }
    }

}