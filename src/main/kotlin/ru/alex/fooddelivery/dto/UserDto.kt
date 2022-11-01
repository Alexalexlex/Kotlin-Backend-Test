package ru.alex.fooddelivery.dto

import java.util.UUID

data class UserDto(
    val id: UUID,
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
)