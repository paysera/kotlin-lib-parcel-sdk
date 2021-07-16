package com.paysera.lib.parcel.clients

import com.paysera.lib.parcel.entities.PSCourierCompanyTokenRequest
import com.paysera.lib.parcel.entities.PSPackageRequest
import com.paysera.lib.parcel.entities.enums.PSPackageStatus
import com.paysera.lib.parcel.entities.filters.PSPackageFilter
import com.paysera.lib.parcel.entities.filters.PSPackagePriceFilter
import com.paysera.lib.parcel.entities.filters.PSTerminalsFilter
import com.paysera.lib.parcel.runCatchingBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ParcelTest : BaseTest() {

    private val country = "LT"
    private val terminalId = "TTJb0-zbCx8jT9FrDMT8rZv6i6VFmdylC"
    private val packageId = "Hiy_sF9gUK9LPEDLieixhcO0SflDGx2br"
    private val cellSize = "xxs"

    private val packageRequest = PSPackageRequest(
        senderName = "Sender Name",
        senderPhone = "+1234567890",
        senderEmail = "sender@email.com",
        receiverName = "Receiver Name",
        receiverPhone = "+1234567899",
        receiverEmail = "receiver@email.com",
        receiverLanguage = "LT",
        sourceTerminalId = "TTJb0-zbCx8jT9FrDMT8rZv6i6VFmdylC",
        destinationTerminalId = "TTJb0-zbCx8jT9FrDMT8rZv6i6VFmdylC",
        size = "xxs",
        cellId = "1234",
        externalId = null,
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
        val filter = PSTerminalsFilter()
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
        val response = apiClient.getTerminalCells(terminalId).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getTerminalSizes() {
        val response = apiClient.getTerminalSizes(terminalId).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.items?.size != null)
    }

    @Test
    fun getPackages() {
        val filter = PSPackageFilter(
            statuses = listOf(
                PSPackageStatus.PENDING,
                PSPackageStatus.CANCELED
            )
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
        val request = PSCourierCompanyTokenRequest("CONDN4XAG34Ifa3QV58TK03hAl__pBYRZj")
        val response = apiClient.refreshToken(request).runCatchingBlocking()
        assert(response.isSuccess)
    }
}