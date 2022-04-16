package ru.alex.fooddelivery.mappers

import ru.alex.fooddelivery.db.entity.DietEntity
import ru.alex.fooddelivery.dto.DietDto

fun DietEntity.toDto() = DietDto(
    id = id,
    title = title,
    description = description,
    image = image,
)