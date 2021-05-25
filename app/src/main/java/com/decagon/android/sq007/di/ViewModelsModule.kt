package com.decagon.android.sq007.di

import com.decagon.android.sq007.model.MainRepository
import com.decagon.android.sq007.view.viewmodels.BlogPostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
//    viewModel { BlogPostsViewModel(mainRepository = get())
    viewModel { BlogPostsViewModel(get()) }
}
