package com.paysera.lib.parcel.entities.enums

enum class PSPackagePaymentStatus(val value: String) {
    NEW("new"),
    AUTHORIZED("authorized"),
    CAPTURED("captured"),
    CANCELED("cancelled")
}