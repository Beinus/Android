package com.example.beinus.common

object HttpRoutes {
    private const val BASE_URL = "http://1.229.206.206:8080"

    private const val USER = "$BASE_URL/user"

    const val GET_ALL_USERS = "$USER/get-all"
    const val SAVE_USER = "$USER/save"
}