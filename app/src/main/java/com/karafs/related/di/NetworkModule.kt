package com.karafs.related.di

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber


private const val BASE_URL = "http://karafsapp.com/"


object ApiQualifier : Qualifier
object LoggerQualifier : Qualifier

val networkModule = module {

    factory<Interceptor>(LoggerQualifier) {
        HttpLoggingInterceptor { log ->
            Timber.d(log)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get(ApiQualifier))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<OkHttpClient>(ApiQualifier) {
        OkHttpClient.Builder().apply {
            addInterceptor(get<Interceptor>(LoggerQualifier))
        }
            .build()
    }

}