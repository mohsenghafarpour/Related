package com.karafs.related.di

import com.karafs.related.data.repository.UserRepository
import com.karafs.related.data.repository.UserRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
}