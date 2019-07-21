package com.example.sabrina.searchuser.repository

import android.util.Log
import com.example.sabrina.searchuser.GitHubApi
import com.example.sabrina.searchuser.model.SearchResponse
import retrofit2.Call
import retrofit2.Response

class DataRepository(val gitHupApi: GitHubApi) {

    fun searchUser(onResponseData: OnResponseData, name: String) {
        gitHupApi.searchUser("user:$name").enqueue(object : retrofit2.Callback<SearchResponse>{

            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                onResponseData.onSuccess((response.body() as SearchResponse))
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                onResponseData.onFailure()
            }

        })
    }

    interface OnResponseData{
        fun onSuccess(data: SearchResponse)
        fun onFailure()
    }
}