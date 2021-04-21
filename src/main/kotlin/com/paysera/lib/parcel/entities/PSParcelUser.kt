package com.paysera.lib.parcel.entities

import java.util.*

data class PSParcelUser(
    val id: String,
    val name: String,
    val phoneNumber: String,
    val email: String,
    val courierCompany: PSCourierCompany?,
    val mainTerminal: PSTerminal?,
    val createdAt: Date,
    val updatedAt: Date
)