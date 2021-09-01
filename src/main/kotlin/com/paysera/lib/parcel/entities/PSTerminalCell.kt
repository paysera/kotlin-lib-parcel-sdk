package com.paysera.lib.parcel.entities

import com.google.gson.annotations.SerializedName

data class PSTerminalCell(
    val id: String,
    @SerializedName("cell_size_object")
    val cellSize: PSCellSize,
    val number: String
)