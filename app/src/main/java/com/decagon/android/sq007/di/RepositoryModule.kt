package com.decagon.android.sq007.di

import com.decagon.android.sq007.cache.PostCacheMapper
import com.decagon.android.sq007.model.MainRepository
import com.decagon.android.sq007.remote.PostNetworkMapper
import org.koin.dsl.module

val repositoryModule = module {
    factory { PostCacheMapper() }
    factory { PostNetworkMapper() }
    single { MainRepository(postDao = get(), postService = get(), cacheMapper = get(), networkMapper = get()) }
}