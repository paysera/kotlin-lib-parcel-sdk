package com.paysera.lib.parcel.entities

import com.paysera.lib.parcel.entities.enums.PSPackageStatus
import org.joda.money.Money
import java.util.Date

data class PSPackage(
    val id: String?,
    val packageNumber: String?,
    val senderName: String,
    val senderPhone: String,
    val senderSmsLanguage: String,
    val senderEmailLanguage: String,
    val senderEmail: String,
    val receiverName: String,
    val receiverPhone: String,
    val receiverEmail: String,
    val receiverLanguage: String?,
    val receiverSmsLanguage: String,
    val receiverEmailLanguage: String,
    val sourceTerminal: PSTerminal?,
    val destinationTerminal: PSTerminal?,
    val status: PSPackageStatus?,
    val size: String,
    val cell: PSCell?,
    val price: Money?,
    val payment: PSPackagePayment?,
    val statusChanges: PSStatusChangeItems,
    val paidAt: Date?,
    val createdAt: Date?,
    val updatedAt: Date?,
    val hashType: String,
)