package com.decagon.android.sq007

import android.app.Application
import com.decagon.android.sq007.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDI()
    }

    private fun configureDI() = startKoin {
        androidContext(this@BaseApplication)
        modules(appComponent)
    }
}