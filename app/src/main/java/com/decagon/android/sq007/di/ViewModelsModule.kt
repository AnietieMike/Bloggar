package com.decagon.android.sq007.di

import com.decagon.android.sq007.viewmodels.BlogPostsViewModel
import com.decagon.android.sq007.viewmodels.PostDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { BlogPostsViewModel(get()) }
    viewModel { PostDetailViewModel(get()) }
}
