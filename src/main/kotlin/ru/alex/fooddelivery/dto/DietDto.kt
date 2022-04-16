package ru.alex.fooddelivery.dto

import java.util.*

data class DietDto(
    val id: UUID,
    val title: String,
    val description: String,
    val image: String
)