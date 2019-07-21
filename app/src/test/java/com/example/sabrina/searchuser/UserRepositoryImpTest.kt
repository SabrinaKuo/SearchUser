package com.example.sabrina.searchuser

import com.example.sabrina.searchuser.data.UserRepository
import com.example.sabrina.searchuser.data.UserRepositoryImp
import org.junit.Test

class UserRepositoryImpTest {

    private val repo: UserRepository

    init {
        repo = UserRepositoryImp()
    }

    @Test
    fun searchUser() {
        repo.searchUser("SabrinaKuo")
    }
}