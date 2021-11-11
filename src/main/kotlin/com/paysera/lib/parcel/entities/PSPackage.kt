package com.paysera.lib.parcel.entities

import com.google.gson.annotations.SerializedName
import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.parcel.entities.enums.PSPackageStatus
import org.joda.money.Money
import java.util.Date

data class PSPackage(
    val id: String?,
    val hashType: String,
    val packageNumber: String?,
    val senderName: String,
    val senderPhone: String,
    val senderEmail: String,
    val receiverName: String,
    val receiverPhone: String?,
    val receiverEmail: String?,
    val receiverLanguage: String?,
    val sourceTerminal: PSTerminal?,
    val destinationTerminal: PSTerminal?,
    @SerializedName("cell_size_object")
    val cellSize: PSCellSize?,
    val cell: PSCell?,
    val price: Money?,
    val payment: PSPackagePayment?,
    val statusChanges: MetadataAwareResponse<PSStatusChange>,
    val paidAt: Date?,
    val createdAt: Date,
    val updatedAt: Date?,
    val storeUntil: Date?
) {
    val status: PSPackageStatus? = null
        get() {
            if (field == null) return PSPackageStatus.PENDING
            return field
        }
}