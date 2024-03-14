package com.example.beinus.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class Employee(
    val name: String,
    val location: String,
    val branch: String
)
