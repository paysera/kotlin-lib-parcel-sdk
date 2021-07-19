package com.paysera.lib.parcel.entities.enums

import com.google.gson.annotations.SerializedName

enum class PSCellState(val value: String) {
    @SerializedName("free")
    FREE("free"),
    @SerializedName("opened")
    OPENED("opened"),
    @SerializedName("occupied")
    OCCUPIED("occupied"),
    @SerializedName("reserved")
    RESERVED("reserved")
}