package com.paysera.lib.parcel.entities.enums

enum class PSPackageStatus(val value: String) {
    PENDING("pending"),
    PAID("paid"),
    TRANSIT("transit"),
    DELIVERED("delivered"),
    RECEIVED("received")
}