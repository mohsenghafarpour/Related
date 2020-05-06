package com.karafs.related.application

import android.app.Application
import com.karafs.related.BuildConfig
import com.karafs.related.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        // Plant Timber logger in
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        /**
         * all injection modules should be added here as a koin module.
         */
        startKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(
                listOf(
                    viewModelModule, networkModule, restModule,
                    repositoryModule, adapterModule, dbModule
                )
            )
        }

    }
}