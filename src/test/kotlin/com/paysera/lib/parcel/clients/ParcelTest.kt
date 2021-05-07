package com.paysera.lib.parcel.clients

import com.paysera.lib.parcel.entities.PSPackage
import com.paysera.lib.parcel.entities.PSPackagePayment
import com.paysera.lib.parcel.entities.filters.PSPackagePriceFilter
import com.paysera.lib.parcel.entities.filters.PSTerminalsFilter
import com.paysera.lib.parcel.runCatchingBlocking
import org.joda.money.CurrencyUnit
import org.joda.money.Money
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.Date

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ParcelTest : BaseTest() {
    //"insert_here"
    private val country = "insert_here"
    private val terminalId = "insert_here"
    private val packageId = "insert_here"
    private val cellSize = "insert_here"
    private val parcel = PSPackage(
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
        price = Money.zero(CurrencyUnit.EUR),
        paidAt = null,
        pinCode = null,
        payment = PSPackagePayment(
            paymentNumber = "insert_here",
            paymentUrl = "insert_here",
            status = "insert_here"),
        status = "insert_here",
        createdAt = Date(0),
        updatedAt = Date(0),
        payOnReceive = null
    )

    @Test
    fun getUser() {
        val response = apiClient.getUser().runCatchingBlocking()
        val result = response.getOrNull()
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
//		assert(result?.id == packageId)
    }

    @Test
    fun getPackageEvent() {
        val response = apiClient.getPackageEvents(packageId).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
//		assert(result?.items?.size != null)
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
        val response = apiClient.registerPackage(parcel, payOnReceive = false).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
//		assert(result?.id == packageId)
    }

    @Test
    fun updatePackage() {
        val response = apiClient.updatePackage(parcel, payOnReceive = true).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
//		assert(result?.id == packageId)
    }

    @Test
    fun unlockPackage() {
        val response = apiClient.unlockPackage(packageId).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun createPackageReturn() {
        val response = apiClient.createPackageReturn(packageId).runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
//		assert(result?.id == packageId")
    }
}