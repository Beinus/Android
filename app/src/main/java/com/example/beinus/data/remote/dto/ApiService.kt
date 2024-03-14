package com.example.beinus.data.remote.dto

import com.example.beinus.data.remote.model.Employee

interface ApiService {
    suspend fun getAllEmployees(): List<Employee>

    suspend fun save(employee: Employee)
}