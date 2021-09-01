package com.paysera.lib.parcel.entities

import com.google.gson.annotations.SerializedName

data class PSTerminalSize(
    @SerializedName("cell_size_object")
    val cellSize: PSCellSize,
    val count: Int
)
