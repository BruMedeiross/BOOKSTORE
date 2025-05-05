package com.brunadev.tm.model

import android.os.Parcelable
import com.brunadev.tm.R
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Images(

    @SerializedName("ratio") var ratio: String? = null,
    @SerializedName("url") var url: String? = "R.drawable.ic_launcher_background",
    @SerializedName("width") var width: Int? = 0,
    @SerializedName("height") var height: Int? = 0,
    @SerializedName("fallback") var fallback: Boolean? = false

) : Parcelable