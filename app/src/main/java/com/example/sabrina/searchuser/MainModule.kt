package com.example.sabrina.searchuser

import com.example.sabrina.searchuser.repository.DataRepository
import com.example.sabrina.searchuser.viewmodel.SearchViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {
    single { DataRepository(get()) }
    single { createWebService() }

    viewModel { SearchViewModel(get()) }
}

fun createWebService(): GitHubApi {
    val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    return retrofit.create(GitHubApi::class.java)
}
