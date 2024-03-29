package ru.alex.fooddelivery.dto

import java.util.UUID
import javax.validation.constraints.Size

data class DietUpdateDto(
    val id: UUID,
    @field:Size(min = 2, max = 100, message = "Diet Title invalid")
    val title: String?,
    @field:Size(min = 10, max = 10000, message = "Diet Title invalid")
    val description: String?,
    @field:Size(min = 10, max = 1000, message = "Diet Title invalid")
    val image: String?
)