package com.brunadev.tm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Start(

    @SerializedName("localDate") var localDate: String? = null,
    @SerializedName("dateTBD") var dateTBD: Boolean? = false,
    @SerializedName("dateTBA") var dateTBA: Boolean? = false,
    @SerializedName("dateTime") var dateTime: String? = null,
    @SerializedName("timeTBA") var timeTBA: Boolean? = false,
    @SerializedName("noSpecificTime") var noSpecificTime: Boolean? = false

):Parcelable