package com.paysera.lib.parcel.entities

import org.joda.money.Money
import java.util.*

data class PSPackage(
	val id: String?,
	val packageNumber: String,
	val senderName: String,
	val senderPhone: String,
	val senderEmail: String,
	val receiverName: String,
	val receiverPhone: String,
	val receiverEmail: String,
	val status: String,
	val sourceTerminalId: String,
	val destinationTerminalId: String,
	val size: String,
	val pinCode: String?,
	val price: Money,
	val payment: PSPackagePayment,
	val createdAt: Date?,
	val updatedAt: Date?,
	val paidAt: Date?,
	var payOnReceive: Boolean?
)