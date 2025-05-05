package com.brunadev.tm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Events(
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("id") var id: String?  = null,
    @SerializedName("test") var test: Boolean? = false,
    @SerializedName("url") var url: String? = null,
    @SerializedName("locale") var locale: String?  = null,
    @SerializedName("images") var images: List<Images>? = null,
    @SerializedName("sales") var sales: Sales? = null,
    @SerializedName("dates") var dates: Dates? = null,
    @SerializedName("classifications") var classifications: List<Classifications>? = null,
    @SerializedName("promoter") var promoter: Promoter? = null,
    @SerializedName("_links") var Links: Links? = null
) : Parcelable

