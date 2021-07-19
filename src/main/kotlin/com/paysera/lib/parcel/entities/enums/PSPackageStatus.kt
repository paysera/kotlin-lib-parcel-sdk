package com.paysera.lib.parcel.entities.enums

import com.google.gson.annotations.SerializedName

enum class PSPackageStatus(val value: String) {
    @SerializedName("pending")
    PENDING("pending"),
    @SerializedName("ready")
    READY("ready"),
    @SerializedName("transit")
    TRANSIT("transit"),
    @SerializedName("delivered")
    DELIVERED("delivered"),
    @SerializedName("received")
    RECEIVED("received"),
    @SerializedName("canceled")
    CANCELED("canceled"),
    @SerializedName("return_requested")
    RETURN_REQUESTED("return_requested"),
    @SerializedName("outdated")
    OUTDATED("outdated")
}