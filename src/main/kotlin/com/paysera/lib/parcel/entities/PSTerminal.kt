package com.paysera.lib.parcel.entities

data class PSTerminal(
    val id: String,
    val country: String,
    val city: String,
    val address: String,
    val postalCode: String,
    val number: String,
    val workingHours: String?,
    val latitude: Double?,
    val longitude: Double?
)
