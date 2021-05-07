package com.paysera.lib.parcel

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

fun <T : Any> Deferred<T>.runCatchingBlocking(): Result<T> = runCatching {
    runBlocking {
        this@runCatchingBlocking.await()
    }
}