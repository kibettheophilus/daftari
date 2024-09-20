package com.theophiluskibet.daftari

import android.app.Application
import com.theophiluskibet.daftari.di.initKoin
import org.koin.android.ext.koin.androidContext

class DaftariApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@DaftariApplication)
        }
    }
}