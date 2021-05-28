package com.decagon.android.sq007.di

import com.decagon.android.sq007.cache.CommentCacheMapper
import com.decagon.android.sq007.cache.PostCacheMapper
import com.decagon.android.sq007.model.MainRepository
import com.decagon.android.sq007.model.remote.CommentNetworkMapper
import com.decagon.android.sq007.model.remote.PostNetworkMapper
import org.koin.dsl.module

val repositoryModule = module {

    factory { PostCacheMapper() }
    factory { PostNetworkMapper() }
    factory { CommentNetworkMapper() }
    factory { CommentCacheMapper() }

    single { MainRepository(
        postDao = get(), 
        postService = get(), 
        postCacheMapper = get(), 
        postNetworkMapper = get(),
        commentCacheMapper = get(),
        commentNetworkMapper = get())
    }
}