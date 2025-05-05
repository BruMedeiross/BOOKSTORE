package com.brunadev.tm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dates (

   @SerializedName("start") var start : Start? = null,
   @SerializedName("timezone") var timezone : String?  = null,
   @SerializedName("status") var status : Status? = null

): Parcelable