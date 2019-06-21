package com.example.twitter

import android.os.Parcel
import android.os.Parcelable

class Comentario(
    var idComentario: Int,
    var autorCom: String,
    var nombreDeUsuarioCom: String,
    var tiempoCom: String,
    var contenidoCom: String/*,
    var numComentarios: Int,
    var numRe: Int,
    var numMeGusta: Int*//*,
    var fecha: String*/

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()/*,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()*//*,
        parcel.readString()*/

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idComentario)
        parcel.writeString(autorCom)
        parcel.writeString(nombreDeUsuarioCom)
        parcel.writeString(tiempoCom)
        parcel.writeString(contenidoCom)
        /*parcel.writeInt(numComentarios)
        parcel.writeInt(numRe)
        parcel.writeInt(numMeGusta)*/
        //parcel.writeString(fecha)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : android.os.Parcelable.Creator<Comentario> {
        override fun createFromParcel(parcel: Parcel): Comentario {
            return Comentario(parcel)
        }

        override fun newArray(size: Int): Array<Comentario?> {
            return arrayOfNulls(size)
        }
    }

}