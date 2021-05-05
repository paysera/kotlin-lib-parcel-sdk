package com.paysera.lib.parcel.clients

import com.paysera.lib.parcel.retrofit.NetworkApiClient
import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import com.paysera.lib.parcel.entities.*
import com.paysera.lib.parcel.entities.filters.PSPackagePriceFilter
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

	fun getPackage(packageId: String) = networkApiClient.getPackage(packageId)

	fun getPackageEvents(packageId: String) = networkApiClient.getPackageStatusChanges(packageId)

	fun getCellSizes() = networkApiClient.getCellSizes()

	fun getPrice(filter: PSPackagePriceFilter) = networkApiClient.getPrice(
        filter.cellSize,
		filter.limit,
		filter.offset,
		filter.orderBy,
		filter.orderDirection,
		filter.after,
		filter.before
    )

	fun getCountries() = networkApiClient.getCountries()

	fun getCities(countryCode: String) = networkApiClient.getCities(countryCode)

	fun registerPackage(`package`: PSPackage, payOnReceive: Boolean): PSPackage {
		`package`.payOnReceive = payOnReceive
		return networkApiClient.registerPackage(`package`)
	}

	fun updatePackage(
        `package`: PSPackage,
        payOnReceive: Boolean
    ): PSPackage {
		`package`.payOnReceive = payOnReceive
		return networkApiClient.updatePackage(`package`)
	}

	fun unlockPackage(packageId: String) = networkApiClient.unlockPackage(packageId)

	fun createPackageReturn(packageId: String) = networkApiClient.createPackageReturn(packageId)
}