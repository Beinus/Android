package com.example.beinus.data.remote.dto

import com.example.beinus.common.HttpRoutes
import com.example.beinus.data.remote.model.Employee
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
    override suspend fun getAllEmployees(): List<Employee> {
        return client.get(HttpRoutes.GET_ALL_EMPLOYEES).body()
    }

    override suspend fun save(employee: Employee) {
        client.post(HttpRoutes.SAVE_EMPLOYEE) {
            contentType(ContentType.Application.Json)
            setBody(employee)
        }
    }
}