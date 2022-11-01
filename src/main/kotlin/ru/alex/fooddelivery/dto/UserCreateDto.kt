package ru.alex.fooddelivery.dto

import javax.validation.constraints.Email
import javax.validation.constraints.Size

data class UserCreateDto(
    @field:Email(message = "User Email invalid")
    val email: String,
    @field:Size(min = 5, max = 100, message = "Password must be longer")
    val password: String,
    @field:Size(min = 2, max = 100, message = "Name must have min 2 letters")
    val firstName: String,
    @field:Size(min = 2, max = 100, message = "Last name must have min 2 letters")
    val lastName: String
)