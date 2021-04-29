package com.paysera.lib.parcel.clients

import com.paysera.lib.common.entities.BaseFilter
import com.paysera.lib.parcel.retrofit.NetworkApiClient
import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import com.paysera.lib.parcel.entities.*
import com.paysera.lib.parcel.entities.filters.PSTerminalsFilter

class ParcelApiClient(
    private val networkApiClient: NetworkApiClient,
    apiRequestManager: ApiRequestManager
) : BaseApiClient(apiRequestManager) {

    fun getUser() = networkApiClient.getUser()

    fun getTerminals(filter: PSTerminalsFilter) = networkApiClient.getTerminals(
        filter.country,
        filter.limit,
        filter.offset,
        filter.orderBy,
        filter.orderDirection,
        filter.after,
        filter.before
    )

    fun getTerminal(terminalId: String) = networkApiClient.getTerminal(terminalId)

    fun getTerminalSizes(terminalId: String) = networkApiClient.getTerminalSizes(terminalId)

    fun registerPackage(`package`: PSPackage) = networkApiClient.registerPackage(`package`)

    fun getPackage(packageId: String) = networkApiClient.getPackage(packageId)

    fun updatePackage(
        packageId: String,
        `package`: PSPackage
    ) = networkApiClient.updatePackage(packageId, `package`)

    fun unlockPackage(packageId: String) = networkApiClient.unlockPackage(packageId)

    fun getPackageEvents(packageId: String) = networkApiClient.getPackageEvents(packageId)

    fun createPackageReturn(packageId: String) = networkApiClient.createPackageReturn(packageId)

    fun getCellSizes() = networkApiClient.getCellSizes()

    fun getPrice(filter: BaseFilter) = networkApiClient.getPrice(
        filter.limit,
        filter.offset,
        filter.orderBy,
        filter.orderDirection,
        filter.after,
        filter.before
    )

    fun getCountries() = networkApiClient.getCountries()

    fun getCities(countryCode: String) = networkApiClient.getCities(countryCode)
}