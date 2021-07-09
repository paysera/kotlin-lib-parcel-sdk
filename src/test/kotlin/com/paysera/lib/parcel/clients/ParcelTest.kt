package com.paysera.lib.parcel.clients

import com.paysera.lib.parcel.entities.PSPackageRequest
import com.paysera.lib.parcel.entities.filters.PSPackageFilter
import com.paysera.lib.parcel.entities.filters.PSPackagePriceFilter
import com.paysera.lib.parcel.entities.filters.PSTerminalsFilter
import com.paysera.lib.parcel.runCatchingBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ParcelTest : BaseTest() {

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
        val response = apiClient.getTerminal("insert_me").runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getTerminalCells() {
        val response = apiClient.getTerminalCells("insert_me").runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getTerminalSizes() {
        val response = apiClient.getTerminalSizes("insert_me").runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.items?.size != null)
    }

    @Test
    fun getPackages() {
        val response = apiClient.getPackages(PSPackageFilter()).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getPackage() {
        val response = apiClient.getPackage("insert_me").runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getPackageStatusChanges() {
        val response = apiClient.getPackageStatusChanges("insert_me").runCatchingBlocking()
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
        val filter = PSPackagePriceFilter(cellSize = "m")
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
        val response = apiClient.getCities("lt").runCatchingBlocking()
        val result = response.getOrNull()
        assert(response.isSuccess)
        assert(result?.items?.size != null)
    }

    @Test
    fun registerPackage() {
        val response = apiClient.registerPackage(PSPackageRequest(size = "m")).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun updatePackage() {
        val response = apiClient.registerPackage(PSPackageRequest()).runCatchingBlocking()
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
        val response = apiClient.unlockPackage("insert_me").runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun providePackage() {
        val response = apiClient.providePackage(
            "insert_me",
            PSPackageRequest()
        ).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun returnPackage() {
        val response = apiClient.returnPackage("insert_me").runCatchingBlocking()
        assert(response.isSuccess)
    }
}