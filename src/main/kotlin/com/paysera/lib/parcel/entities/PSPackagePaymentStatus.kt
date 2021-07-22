package com.paysera.lib.parcel.entities

import com.google.gson.annotations.SerializedName

enum class PSPackagePaymentStatus(val value: String) {
    @SerializedName("new")
    NEW("new"),
    @SerializedName("authorized")
    AUTHORIZED("authorized"),
    @SerializedName("captured")
    CAPTURED("captured"),
    @SerializedName("cancelled")
    CANCELLED("cancelled")
}