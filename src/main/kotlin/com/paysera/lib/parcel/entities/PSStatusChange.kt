package com.paysera.lib.parcel.entities

import com.paysera.lib.parcel.entities.enums.PSPackageStatus
import java.util.*

data class PSStatusChange(
    val status: PSPackageStatus?,
    val createdAt: Date?
)