package com.paysera.lib.parcel.clients

import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import com.paysera.lib.parcel.entities.PSPackageRequest
import com.paysera.lib.parcel.entities.filters.PSPackageFilter
import com.paysera.lib.parcel.entities.filters.PSPackagePriceFilter
import com.paysera.lib.parcel.entities.filters.PSTerminalsFilter
import com.paysera.lib.parcel.retrofit.NetworkApiClient

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

    fun getTerminalCells(terminalId: String) = networkApiClient.getTerminalCells(terminalId)

    fun getTerminalSizes(terminalId: String) = networkApiClient.getTerminalSizes(terminalId)

    fun getPackages(filter: PSPackageFilter) = networkApiClient.getPackages(
        offset = filter.offset,
        limit = filter.limit,
        orderBy = filter.orderBy,
        orderDirection = filter.orderDirection,
        after = filter.after,
        before = filter.before,
        statuses = filter.statuses?.map { it.value },
        receiverPhonePart = filter.receiverPhonePart,
        fromCreatedAt = filter.fromCreatedAt,
        toCreatedAt = filter.toCreatedAt,
        number = filter.number,
        externalId = filter.externalId,
        isPaid = filter.isPaid,
        isReceiver = filter.isReceiver
    )

    fun getPackage(packageId: String) = networkApiClient.getPackage(packageId)

    fun getPackageStatusChanges(packageId: String) = networkApiClient.getPackageStatusChanges(packageId)

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

    fun registerPackage(packageRequest: PSPackageRequest) = networkApiClient.registerPackage(packageRequest)

    fun updatePackage(
        packageId: String,
        packageRequest: PSPackageRequest
    ) = networkApiClient.updatePackage(
        packageId,
        packageRequest
    )

    fun unlockPackage(packageId: String) = networkApiClient.unlockPackage(packageId)

    fun providePackage(
        packageId: String,
        packageRequest: PSPackageRequest
    ) = networkApiClient.providePackage(
        packageId,
        packageRequest
    )

    fun returnPackage(packageId: String) = networkApiClient.returnPackage(packageId)
}