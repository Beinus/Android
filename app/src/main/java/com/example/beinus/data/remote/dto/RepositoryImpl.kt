package com.example.beinus.data.remote.dto

import com.example.beinus.data.remote.model.Employee
import com.example.beinus.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: ApiService
): Repository {
    override suspend fun getAllEmployees(): List<Employee> {
        return api.getAllEmployees()
    }

    override suspend fun save(employee: Employee) {
        api.save(employee = employee)
    }
}