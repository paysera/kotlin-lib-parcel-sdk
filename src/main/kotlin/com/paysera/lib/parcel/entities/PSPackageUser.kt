package com.paysera.lib.parcel.entities

import java.util.Date

data class PSPackageUser(
    val id: String,
    val name: String?,
    val phoneNumber: String?,
    val email: String?,
    val courierCompanies: List<PSCourierCompany>?,
    val mainTerminal: PSTerminal?,
    val createdAt: Date,
    val updatedAt: Date?
)