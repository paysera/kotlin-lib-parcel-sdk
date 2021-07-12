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
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiJwYXJjZWxfbmV0d29ya19hcGkiLCJpc3MiOiJhdXRoX2FwaSIsImV4cCI6MTYyNjExNDU4NCwianRpIjoiUEZmMUNWRV9wUHczenM5NHNxUnlXUUt3MUk3ZFRab2UiLCJwc3I6cyI6WyJsb2dnZWRfaW4iXSwicHNyOnUiOiI4NDY5OTA2IiwicHNyOnNpZCI6IjBlWXhUV21pU1Zrd19JcjR5NHZGNi1Bd0pIdXdPU3VaIiwicHNyOmEiOnsidXNlcl9pZCI6Ijg0Njk5MDYifSwiaWF0IjoxNjI2MDcxMzg0fQ.iM4FnGit0aPQpny3A7EkFafcml0tIDB6CvVGqWjW0rjBXhqSM1Peb0i7jbWaJRnD5aO3Yjcj_-9GocYeNZ3C5cwdGvUwAM-0pqBvaUkforMb5oBy9a9lkZsIAG9PcvZ9BlQGe5T0vPR1EM7dDrDv4aueathwxez3W5KG4bY81m_rZG-NgTWi4HgtQNtwg3wAh9d_l36wIAibt8ZAvaVAJHuGZOmcc_g8-x0W_TckUnagdSftlsqH-z7CpVMwS_gygfj-DzEpUHLuUoevdn6ixQBBFk41fWpw2aMWTYn3HbBH2TUcFjF7oZF4_KiC2IuoevN5cz3fEYmEy4BMa9VXqw",
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
            baseUrl = "https://parcel-api.paysera.net/public/rest/v1/",
            locale = "lt",
            userAgent = userAgent,
            credentials = apiCredentials,
            certifiedHosts = listOf("parcel-api.paysera.net"),
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