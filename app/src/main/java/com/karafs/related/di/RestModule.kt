package com.karafs.related.di

import com.karafs.related.network.api.UserApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

val restModule = module {
    factory<UserApi> { get<Retrofit>().create() }
}