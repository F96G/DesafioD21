package com.munidigital.bc2201.desafiod21

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Moneda(val nombre:String, val abreviatura:String, val precio:Double, val fecha:String, val imagen:Int) :
    Parcelable {
}