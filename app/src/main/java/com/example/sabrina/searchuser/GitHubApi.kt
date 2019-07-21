package com.example.sabrina.searchuser

import com.example.sabrina.searchuser.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubApi {
    @GET("search/users")
    fun searchUser(@Query("q") query: String):Call<SearchResponse>
}