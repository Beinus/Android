package com.example.beinus.common

object HttpRoutes {
    private const val BASE_URL = "http://1.229.206.206:8080"

    private const val EMPLOYEE = "$BASE_URL/employee"

    const val GET_ALL_EMPLOYEES = "$EMPLOYEE/get-all"
    const val SAVE_EMPLOYEE = "$EMPLOYEE/save"
}