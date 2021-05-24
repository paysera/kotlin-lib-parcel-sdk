package com.paysera.lib.parcel.entities

import java.util.Date

data class PSPackageEvent(
    val status: String,
    val createdAt: Date?
)
