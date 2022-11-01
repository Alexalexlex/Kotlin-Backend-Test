package ru.alex.fooddelivery.mappers

import ru.alex.fooddelivery.db.entity.DietEntity
import ru.alex.fooddelivery.db.entity.UserEntity
import ru.alex.fooddelivery.dto.DietDto
import ru.alex.fooddelivery.dto.UserDto
import java.util.*

fun DietEntity.toDto() = DietDto(
    id = id,
    title = title,
    description = description,
    image = image,
)

fun UserEntity.toDto() = UserDto(
    id = id,
    firstName = firstName,
    lastName = lastName,
    email = email,
    password = password,
)