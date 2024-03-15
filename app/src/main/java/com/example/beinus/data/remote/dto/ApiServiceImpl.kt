package com.example.beinus.data.remote.dto

import com.example.beinus.common.HttpRoutes
import com.example.beinus.data.remote.model.User
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(
    private val client: HttpClient
) : ApiService {
    override suspend fun getAllUsers(): List<User> {
        return client.get(HttpRoutes.GET_ALL_USERS).body()
    }

    override suspend fun save(user: User) {
        client.post(HttpRoutes.SAVE_USER) {
            contentType(ContentType.Application.Json)
            setBody(user)
        }
    }
}