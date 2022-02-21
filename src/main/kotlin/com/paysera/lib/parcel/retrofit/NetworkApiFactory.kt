package com.paysera.lib.parcel.retrofit

import com.paysera.lib.parcel.clients.ParcelApiClient
import com.paysera.lib.common.interfaces.BaseApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import okhttp3.logging.HttpLoggingInterceptor

class NetworkApiFactory(
    baseUrl: String,
    locale: String?,
    userAgent: String?,
    credentials: BaseApiCredentials,
    certifiedHosts: List<String> = emptyList(),
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface
) : BaseApiFactory<ParcelApiClient>(
    baseUrl,
    locale,
    userAgent,
    credentials,
    certifiedHosts,
    timeout,
    httpLoggingInterceptorLevel,
    errorLogger
) {
    override fun createClient(tokenRefresher: TokenRefresherInterface?): ParcelApiClient {
        createRetrofit(tokenRefresher).apply {
            return ParcelApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}