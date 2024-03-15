package com.example.beinus.domain.repository

import com.example.beinus.data.remote.model.User

interface Repository {
    suspend fun getAllUsers(): List<User>

    suspend fun save(user: User)
}