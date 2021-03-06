package com.paysera.lib.parcel.entities.filters

class PSTerminalsFilter(
    val country: String? = null,
    val city: String? = null,
    val address: String? = null,
    courierCompanyId: String? = null,
    offset: Int? = null,
    limit: Int? = null,
    orderBy: String? = null,
    orderDirection: String? = null,
    after: String? = null,
    before: String? = null
) : PSBaseCompanyFilter(
    courierCompanyId = courierCompanyId,
    offset = offset,
    limit = limit,
    orderBy = orderBy,
    orderDirection = orderDirection,
    after = after,
    before = before
)