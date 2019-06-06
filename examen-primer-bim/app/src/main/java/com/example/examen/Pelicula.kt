package com.example.examen

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Pelicula (
    var identificadorPelicula :Int,
    var nombre :String,
    var anioLanzamiento :Int,
    var rating :Int,
    var actoresPrincipales:String,
    var sinopsis:String,
    var actorId :Int):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(identificadorPelicula)
        parcel.writeString(nombre)
        parcel.writeInt(anioLanzamiento)
        parcel.writeInt(rating)
        parcel.writeString(actoresPrincipales)
        parcel.writeString(sinopsis)
        parcel.writeInt(actorId)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pelicula> {
        override fun createFromParcel(parcel: Parcel): Pelicula {
            return Pelicula(parcel)
        }

        override fun newArray(size: Int): Array<Pelicula?> {
            return arrayOfNulls(size)
        }
    }

}