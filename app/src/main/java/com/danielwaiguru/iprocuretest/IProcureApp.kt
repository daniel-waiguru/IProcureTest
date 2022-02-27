package com.danielwaiguru.iprocuretest

import android.app.Application
import com.danielwaiguru.presentation.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class IProcureApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@IProcureApp)
            androidLogger(Level.ERROR)
            modules(appModules)
        }
    }
}