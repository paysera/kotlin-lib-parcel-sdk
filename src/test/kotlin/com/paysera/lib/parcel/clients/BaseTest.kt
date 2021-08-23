package com.paysera.lib.parcel.clients

import com.paysera.lib.common.entities.ApiCredentials
import com.paysera.lib.common.exceptions.ApiError
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.parcel.retrofit.NetworkApiFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle

@TestInstance(Lifecycle.PER_METHOD)
open class BaseTest {

    companion object {
        private val userAgent = "okhttp/3.12.1"
        private val apiCredentials = ApiCredentials(
            "insert_here",
            120000
        )
        private val timeout: Long? = null
        private val loggingLevel = HttpLoggingInterceptor.Level.BODY

        private val errorLoggerInterface = object : ErrorLoggerInterface {
            override fun log(request: Request, error: ApiError) {
                //  log
            }
        }
        private val tokenRefresher = object : TokenRefresherInterface {
            override fun refreshToken(): Deferred<Any> {
                return CompletableDeferred(1)
            }
        }
    }

    protected lateinit var apiClient: ParcelApiClient

    @BeforeAll
    open fun setUp() {
        apiClient = NetworkApiFactory(
            baseUrl = "https://lockers-sandbox-api.paysera.com/public/rest/v1/",
            locale = "lt",
            userAgent = userAgent,
            credentials = apiCredentials,
            certifiedHosts = listOf("lockers-sandbox-api.paysera.com"),
            timeout = timeout,
            httpLoggingInterceptorLevel = loggingLevel,
            errorLogger = errorLoggerInterface
        ).createClient(tokenRefresher)
    }

    @AfterAll
    open fun tearDown() {
        apiClient.cancelCalls()
    }
}