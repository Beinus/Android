package com.example.beinus.data.remote.dto

import com.example.beinus.data.remote.model.User

interface ApiService {
    suspend fun getAllUsers(): List<User>

    suspend fun save(user: User)
}