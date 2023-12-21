package com.tugasakhir.gostadz

import android.app.Application
import com.tugasakhir.gostadz.di.firebaseModules
import com.tugasakhir.gostadz.di.repositoryModule
import com.tugasakhir.gostadz.di.useCaseModules
import com.tugasakhir.gostadz.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KoinApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KoinApp)
            modules(listOf(firebaseModules, repositoryModule, viewModelModules, useCaseModules))
        }
    }
}