package com.paysera.lib.parcel.entities

import java.util.Date

data class PSPackageUser(
    val id: String,
    val name: String,
    val phoneNumber: String,
    val email: String?,
    val courierCompany: PSCourierCompany?,
    val mainTerminal: PSTerminal?,
    val suspended: Boolean,
    val createdAt: Date,
    val updatedAt: Date?
)