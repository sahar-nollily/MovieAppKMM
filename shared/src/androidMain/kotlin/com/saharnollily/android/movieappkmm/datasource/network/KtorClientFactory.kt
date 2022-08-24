package com.saharnollily.android.movieappkmm.datasource.network

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

actual class KtorClientFactory actual constructor() {
    actual fun build(): HttpClient{
        return HttpClient(Android){
            install(JsonFeature){
                serializer = KotlinxSerializer(
                    kotlinx.serialization.json.Json {
                        ignoreUnknownKeys = true
                        coerceInputValues = true // builder to coerce nulls to default values
                    }
                )
            }
        }
    }

}