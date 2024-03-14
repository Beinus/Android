package com.example.beinus.domain.repository

import com.example.beinus.data.remote.model.Employee

interface Repository {
    suspend fun getAllEmployees(): List<Employee>

    suspend fun save(employee: Employee)
}