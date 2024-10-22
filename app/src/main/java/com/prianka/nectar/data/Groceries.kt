@file:Suppress("DEPRECATED_ANNOTATION")

package com.prianka.nectar.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Groceries(
    val id: Int,
    val groceryName: String?,
    val quantity: Int?,
    val price: Double?,
    val imageUrl: String?
): Parcelable
