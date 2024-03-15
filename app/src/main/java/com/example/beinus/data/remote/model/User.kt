package com.example.beinus.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val userID: String,
    val userPW: String
)
