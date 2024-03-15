package com.example.beinus.data.remote.dto

import com.example.beinus.data.remote.model.User
import com.example.beinus.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ApiService
): Repository {
    override suspend fun getAllUsers(): List<User> {
        return api.getAllUsers()
    }

    override suspend fun save(user: User) {
        api.save(user = user)
    }
}