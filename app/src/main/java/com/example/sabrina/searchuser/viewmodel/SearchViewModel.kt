package com.example.sabrina.searchuser.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.sabrina.searchuser.model.SearchResponse
import com.example.sabrina.searchuser.model.User
import com.example.sabrina.searchuser.repository.DataRepository
import org.koin.standalone.KoinComponent

class SearchViewModel(private val dataRepository: DataRepository):ViewModel(), KoinComponent {

    var listOfUser = MutableLiveData<List<User>>()

    init {
        listOfUser.value = listOf()
    }

    fun searchUser(queryName:String) {
        dataRepository.searchUser(object : DataRepository.OnResponseData{
            override fun onSuccess(data: SearchResponse) {
                listOfUser.value = data.items
            }

            override fun onFailure() {
            }
        }, queryName)
    }
}