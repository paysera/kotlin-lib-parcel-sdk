package com.paysera.lib.parcel.entities

import com.paysera.lib.parcel.entities.enums.PSCellState

data class PSCell(
    var id: String,
    var index: String,
    var number: String,
    var size: String,
    var state: PSCellState? = null,
    var courierCompanyReservation: PSCourierCompany? = null,
    var hiddenFromAll: Boolean,
    var hiddenFromCompanies: List<PSCourierCompany>,
    var `package`: PSPackage,
    var pinCode: String? = null,
)