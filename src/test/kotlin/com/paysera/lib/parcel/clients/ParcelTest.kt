package com.paysera.lib.parcel.clients

import com.paysera.lib.parcel.entities.PSCourierCompanyTokenRequest
import com.paysera.lib.parcel.entities.PSPackageRequest
import com.paysera.lib.parcel.entities.enums.PSPackageStatus
import com.paysera.lib.parcel.entities.filters.PSBaseCompanyFilter
import com.paysera.lib.parcel.entities.filters.PSPackageFilter
import com.paysera.lib.parcel.entities.filters.PSPackagePriceFilter
import com.paysera.lib.parcel.entities.filters.PSTerminalsFilter
import com.paysera.lib.parcel.runCatchingBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ParcelTest : BaseTest() {

    private val country = "LT"
    private val terminalId = ""//Mock terminal
    private val packageId = ""
    private val cellSize = ""
    private val courierCompany = ""

    private val packageRequest = PSPackageRequest(
        senderName = "",
        senderPhone = "+3709989898",
        senderEmail = "",
        receiverName = "Receiver Name",
        receiverPhone = "+3709989898",
        receiverEmail = "receiver@email.com",
        receiverLanguage = "LT",
        sourceTerminalId = "",
        destinationTerminalId = "",
        size = "s",
        cellId = "",
        externalId = "",
        sendNotifications = null,
        payOnReceive = null
    )

    @Test
    fun getUser() {
        val response = apiClient.getUser().runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getTerminals() {
        val filter = PSTerminalsFilter(courierCompanyId = courierCompany)
        val response = apiClient.getTerminals(filter).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result != null)
        assert(result?.items?.size!! > 0)
    }

    @Test
    fun getTerminal() {
        val response = apiClient.getTerminal(terminalId).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getTerminalCells() {
        val filter = PSBaseCompanyFilter(courierCompanyId = courierCompany)
        val response = apiClient.getTerminalCells(terminalId, filter).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getTerminalSizes() {
        val filter = PSBaseCompanyFilter(courierCompanyId = courierCompany)
        val response = apiClient.getTerminalSizes(terminalId, filter).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.items?.size != null)
    }

    @Test
    fun getPackages() {
        val filter = PSPackageFilter(
            externalId = "",
            courierCompanyId = courierCompany
        )
        val response = apiClient.getPackages(filter).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getPackage() {
        val response = apiClient.getPackage(packageId).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getPackageStatusChanges() {
        val response = apiClient.getPackageStatusChanges(packageId).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.items?.size != null)
    }

    @Test
    fun getCellSizes() {
        val response = apiClient.getCellSizes().runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.items?.size != null)
    }

    @Test
    fun getPrice() {
        val filter = PSPackagePriceFilter(cellSize = cellSize)
        val response = apiClient.getPrice(filter).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.isPositive == true)
    }

    @Test
    fun getCountries() {
        val response = apiClient.getCountries().runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.items?.size != null)
    }

    @Test
    fun getCities() {
        val response = apiClient.getCities(country).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.items?.size != null)
    }

    @Test
    fun registerPackage() {
        val response = apiClient.registerPackage(packageRequest).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun updatePackage() {
        val response = apiClient.registerPackage(packageRequest).runCatchingBlocking()
        val packageRegistered = response.getOrNull()
        if (packageRegistered != null) {
            val response2 = apiClient.updatePackage(
                packageRegistered.id!!,
                PSPackageRequest()
            ).runCatchingBlocking()
            val result = response2.getOrNull()
            assert(response2.isSuccess)
            assert(result?.id == packageRegistered.id)
        }
    }

    @Test
    fun unlockPackage() {
        val response = apiClient.unlockPackage(packageId).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun providePackage() {
        val response = apiClient.providePackage(
            packageId,
            packageRequest
        ).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun returnPackage() {
        val response = apiClient.returnPackage(packageId).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun refreshToken() {
        val request = PSCourierCompanyTokenRequest(courierCompany)
        val response = apiClient.refreshToken(request).runCatchingBlocking()
        assert(response.isSuccess)
    }
}