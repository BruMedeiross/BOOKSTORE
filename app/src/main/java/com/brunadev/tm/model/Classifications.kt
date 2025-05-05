package com.brunadev.tm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Classifications(

    @SerializedName("primary") var primary: Boolean? = false,
    @SerializedName("segment") var segment: Segment? = null,
    @SerializedName("genre") var genre: Genre? = null,
    @SerializedName("subGenre") var subGenre: SubGenre? = null
) : Parcelable