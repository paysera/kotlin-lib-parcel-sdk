package com.paysera.lib.parcel.retrofit

import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.parcel.entities.*
import kotlinx.coroutines.Deferred
import org.joda.money.Money
import retrofit2.Response
import retrofit2.http.*

interface NetworkApiClient {

    @GET("terminals")
    fun getTerminals(
        @Query("country") country: String?,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?,
        @Query("order_by") orderBy: String?,
        @Query("order_direction") orderDirection: String?,
        @Query("after") after: String?,
        @Query("before") before: String?
    ): Deferred<MetadataAwareResponse<PSTerminal>>

    @GET("terminals/{terminal_id}")
    fun getTerminal(
        @Path("terminal_id") terminalId: String
    ): Deferred<PSTerminal>

    @GET("terminals/{terminal_id}/cells")
    fun getTerminalCells(
        @Path("terminal_id") terminalId: String
    ): Deferred<MetadataAwareResponse<PSTerminalCell>>

    @GET("terminals/{terminal_id}/sizes")
    fun getTerminalSizes(
        @Path("terminal_id") terminalId: String
    ): Deferred<MetadataAwareResponse<PSTerminalSize>>

    @GET("packages")
    fun getPackages(
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        @Query("order_by") orderBy: String?,
        @Query("order_direction") orderDirection: String?,
        @Query("after") after: String?,
        @Query("before") before: String?,
        @Query("statuses") statuses: List<String>?,
        @Query("receiver_phone_part") receiverPhonePart: String?,
        @Query("created_at_from") fromCreatedAt: String?,
        @Query("created_at_to") toCreatedAt: String?,
        @Query("number") number: String?,
        @Query("external_id") externalId: String?,
        @Query("is_paid") isPaid: Boolean?,
        @Query("is_receiver") isReceiver: Boolean?
    ): Deferred<MetadataAwareResponse<PSPackage>>

    @GET("packages/{package_id}")
    fun getPackage(
        @Path("package_id") packageId: String
    ): Deferred<PSPackage>

    @GET("packages/{package_id}/events")
    fun getPackageStatusChanges(
        @Path("package_id") packageId: String
    ): Deferred<MetadataAwareResponse<PSStatusChange>>

    @GET("cell-sizes")
    fun getCellSizes(): Deferred<MetadataAwareResponse<PSCellSize>>

    @GET("price")
    fun getPrice(
        @Query("cell_size") cellSize: String,
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?,
        @Query("order_by") orderBy: String?,
        @Query("order_direction") orderDirection: String?,
        @Query("after") after: String?,
        @Query("before") before: String?
    ): Deferred<Money>

    @GET("countries")
    fun getCountries(): Deferred<MetadataAwareResponse<PSPackageCountry>>

    @GET("countries/{country_code}/cities")
    fun getCities(
        @Path("country_code") countryCode: String
    ): Deferred<MetadataAwareResponse<PSCity>>

    @GET("me")
    fun getUser(): Deferred<PSPackageUser>

    @PUT("packages/{package_id}")
    fun updatePackage(
        @Path("package_id") packageId: String,
        @Body packageRequest: PSPackageRequest
    ): Deferred<PSPackage>

    @PUT("packages/{package_id}/unlock")
    fun unlockPackage(
        @Path("package_id") packageId: String
    ): Deferred<Response<Void>>

    @PUT("packages/{package_id}/return")
    fun returnPackage(
        @Path("package_id") packageId: String
    ): Deferred<PSPackage>

    @POST("packages")
    fun registerPackage(
        @Body packageRequest: PSPackageRequest
    ): Deferred<PSPackage>

    @POST("packages/{package_id}/provide")
    fun providePackage(
        @Path("package_id") packageId: String,
        @Body packageRequest: PSPackageRequest
    ): Deferred<PSPackage>
}