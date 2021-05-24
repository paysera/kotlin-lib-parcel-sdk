package com.paysera.lib.parcel.clients

import com.paysera.lib.parcel.entities.PSPackage
import com.paysera.lib.parcel.entities.filters.PSPackagePriceFilter
import com.paysera.lib.parcel.entities.filters.PSTerminalsFilter
import com.paysera.lib.parcel.runCatchingBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ParcelTest : BaseTest() {
    //"insert_here"
    private val country = "insert_here"
    private val terminalId = "insert_here"
    private val packageId = "insert_here"
    private val cellSize = "insert_here"
    private val parcelToRegister = PSPackage(
        id = "insert_here",
        packageNumber = "insert_here",
        senderName = "insert_here",
        senderPhone = "insert_here",
        senderEmail = "insert_here",
        receiverName = "insert_here",
        receiverPhone = "insert_here",
        receiverEmail = "insert_here",
        sourceTerminalId = "insert_here",
        destinationTerminalId = "insert_here",
        size = "insert_here",
        price = null,
        paidAt = null,
        pinCode = null,
        payment = null,
        status = null,
        createdAt = null,
        updatedAt = null,
        payOnReceive = null
    )

    @Test
    fun getUser() {
        val response = apiClient.getUser().runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getTerminals() {
        val filter = PSTerminalsFilter(country = country)
        val response = apiClient.getTerminals(filter).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result != null)
        assert(result?.items?.size!! > 0)
    }

    @Test
    fun getTerminal() {
        val response = apiClient.getTerminal(terminalId).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.id == terminalId)
    }

    @Test
    fun getTerminalSizes() {
        val response = apiClient.getTerminalSizes(terminalId).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.items?.size != null)
    }

    @Test
    fun getPackage() {
        val response = apiClient.getPackage(packageId).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.id == packageId)
    }

    @Test
    fun getPackageEvent() {
        val response = apiClient.getPackageEvents(packageId).runCatchingBlocking()
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
        val response = apiClient.registerPackage(parcelToRegister, payOnReceive = false).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun updatePackage() {
        val response = apiClient.registerPackage(parcelToRegister, payOnReceive = false).runCatchingBlocking()
        val packageRegistered = response.getOrNull()
        if (packageRegistered != null) {
            val response2 = apiClient.updatePackage(packageRegistered, payOnReceive = true).runCatchingBlocking()
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
    fun createPackageReturn() {
        val response = apiClient.createPackageReturn(packageId).runCatchingBlocking()
        assert(response.isSuccess)
    }
}