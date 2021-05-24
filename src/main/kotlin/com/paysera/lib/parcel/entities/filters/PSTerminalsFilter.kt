package com.paysera.lib.parcel.entities.filters

import com.paysera.lib.common.entities.BaseFilter

class PSTerminalsFilter(
    val country: String? = null,
    offset: Int? = null,
    limit: Int? = null,
    orderBy: String? = null,
    orderDirection: String? = null,
    after: String? = null,
    before: String? = null,
) : BaseFilter(
    offset = offset,
    limit = limit,
    orderBy = orderBy,
    orderDirection = orderDirection,
    after = after,
    before = before
)