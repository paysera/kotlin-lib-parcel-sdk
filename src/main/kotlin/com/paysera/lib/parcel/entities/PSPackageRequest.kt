package com.paysera.lib.parcel.entities

data class PSPackageRequest(
    val senderName: String? = null,
    val senderPhone: String? = null,
    val senderEmail: String? = null,
    val receiverName: String? = null,
    val receiverPhone: String? = null,
    val receiverEmail: String? = null,
    val receiverLanguage: String? = null,
    val sourceTerminalId: String? = null,
    val destinationTerminalId: String? = null,
    val size: String? = null,
    val cellId: String? = null,
    val externalId: String? = null,
    val sendNotifications: Boolean? = null,
    val payOnReceive: Boolean? = null
)