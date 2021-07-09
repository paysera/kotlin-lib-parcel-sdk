package com.paysera.lib.parcel.entities

data class PSPackagePayment(
    val paymentNumber: String,
    val paymentUrl: String,
    val status: PSPackagePaymentStatus?
)