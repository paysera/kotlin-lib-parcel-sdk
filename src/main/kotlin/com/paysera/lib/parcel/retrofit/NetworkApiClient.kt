package com.paysera.lib.parcel.retrofit

import com.paysera.lib.common.entities.MetadataAwareResponse
import com.paysera.lib.parcel.entities.*
import kotlinx.coroutines.Deferred
import org.joda.money.Money
import retrofit2.Response
import retrofit2.http.*

interface NetworkApiClient {

	@GET("me")
	fun getUser(): Deferred<PSParcelUser>

	@GET("terminals")
	fun getTerminals(
		@Query("country") country: String?,
		@Query("limit") limit: Int?,
		@Query("offset") offset: Int?,
		@Query("order_by") orderBy: String?,
		@Query("order_direction") orderDirection: String?,
		@Query("after") after: String?,
		@Query("before") before: String?,
	): Deferred<MetadataAwareResponse<PSTerminal>>

	@GET("terminals/{terminalId}")
	fun getTerminal(
		@Path("terminalId") terminalId: String
	): Deferred<PSTerminal>

	@GET("terminals/{terminalId}/sizes")
	fun getTerminalSizes(
		@Path("terminalId") terminalId: String
	): Deferred<MetadataAwareResponse<PSTerminalSize>>

	@GET("packages/{package_id}")
	fun getPackage(
		@Path("package_id") packageId: String
	): Deferred<PSPackage>

	@GET("packages/{package_id}/events")
	fun getPackageStatusChanges(
		@Path("package_id") packageId: String,
	): Deferred<MetadataAwareResponse<PSPackageEvent>>

	@GET("cell-sizes")
	fun getCellSizes(): Deferred<MetadataAwareResponse<PSCellSize>>

	@GET("price")
	fun getPrice(
		@Query("cell_size") cellSize: String?,
		@Query("limit") limit: Int?,
		@Query("offset") offset: Int?,
		@Query("order_by") orderBy: String?,
		@Query("order_direction") orderDirection: String?,
		@Query("after") after: String?,
		@Query("before") before: String?
	): Deferred<Money>

	@GET("countries")
	fun getCountries(): Deferred<MetadataAwareResponse<PSCountry>>

	@GET("countries/{countryCode}/cities")
	fun getCities(
		@Path("countryCode") countryCode: String,
	): Deferred<MetadataAwareResponse<PSCity>>

	@POST("packages")
	fun registerPackage(
		@Body `package`: PSPackage,
	): Deferred<PSPackage>

	@PUT("packages/{package_id}")
	fun updatePackage(
		@Body `package`: PSPackage,
	): Deferred<PSPackage>

	@PUT("packages/{package_id}/unlock")
	fun unlockPackage(
		@Path("package_id") packageId: String
	): Deferred<Response<Void>>

	@PUT("packages/{package_id}/return")
	fun createPackageReturn(
		@Path("package_id") packageId: String,
	): Deferred<PSPackage>
}