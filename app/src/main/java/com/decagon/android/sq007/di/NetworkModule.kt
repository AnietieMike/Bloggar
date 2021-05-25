package com.decagon.android.sq007.di

import com.decagon.android.sq007.apis.PostService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val networkModule : Module = module {

    factory { httpClient }
    factory { logging }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory {
        get<Retrofit>().create(PostService::class.java)
    }
}

val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
private val httpClient = OkHttpClient.Builder().addInterceptor(logging).build()