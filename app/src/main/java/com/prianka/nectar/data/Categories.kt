package com.prianka.nectar.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Categories(
    val id: Int,
    val categoryName: String?,
    val quantity: Int?,
    val price: Double?,
    val imageUrl: String?
): Parcelable
