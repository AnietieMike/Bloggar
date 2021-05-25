package com.decagon.android.sq007.di

import com.decagon.android.sq007.model.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepository(postDao = get(), postService = get(), cacheMapper = get(), networkMapper = get()) }
}