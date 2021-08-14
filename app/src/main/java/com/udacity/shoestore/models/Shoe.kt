package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import timber.log.Timber

@Parcelize
data class Shoe(
    var name: String, var size: Double, var company: String, var description: String,
    val images: List<String> = mutableListOf()
) : Parcelable {

    fun getSize(): String {
        return size.toString()
    }

    fun setSize(text: String) {
        try {
            size = when {
                text.isEmpty() -> 0.0
                text == "." -> 0.0
                text == "-" -> -.0
                else -> text.toDouble()
            }
        } catch (e: NumberFormatException) {
            Timber.i(e)
        }
    }
}