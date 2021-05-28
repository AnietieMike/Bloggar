package com.decagon.android.sq007.di

import androidx.room.Room
import com.decagon.android.sq007.R
import com.decagon.android.sq007.cache.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val cacheModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        ).build()
    }

    single {
        get<AppDatabase>().cacheDao()
    }
}
