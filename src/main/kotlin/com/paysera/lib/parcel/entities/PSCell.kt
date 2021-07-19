package com.paysera.lib.parcel.entities

import com.paysera.lib.parcel.entities.enums.PSCellState

data class PSCell(
    var id: String,
    var number: String,
    var size: String,
    var state: PSCellState? = null,
    var pinCode: String? = null,
)