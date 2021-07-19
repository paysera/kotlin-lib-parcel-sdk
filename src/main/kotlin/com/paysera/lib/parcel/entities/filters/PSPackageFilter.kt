package com.paysera.lib.parcel.entities.filters

import com.google.gson.annotations.SerializedName
import com.paysera.lib.common.entities.BaseFilter
import com.paysera.lib.parcel.entities.enums.PSPackageStatus

class PSPackageFilter(
    val statuses: List<PSPackageStatus>? = null,
    val receiverPhonePart: String? = null,
    @SerializedName("created_at_from")
    val fromCreatedAt: String? = null,
    @SerializedName("created_at_to")
    val toCreatedAt: String? = null,
    val number: String? = null,
    val externalId: String? = null,
    val isPaid: Boolean? = null,
    val isReceiver: Boolean? = null,
    offset: Int? = null,
    limit: Int? = null,
    orderBy: String? = null,
    orderDirection: String? = null,
    after: String? = null,
    before: String? = null
) : BaseFilter(
    offset = offset,
    limit = limit,
    orderBy = orderBy,
    orderDirection = orderDirection,
    after = after,
    before = before
)