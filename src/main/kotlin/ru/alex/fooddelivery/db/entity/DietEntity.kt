package ru.alex.fooddelivery.db.entity

import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.*

@Table("diets")
data class DietEntity(
    val title: String,
    val description: String,
    val image: String,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant? = null,
    val deletedAt: Instant? = null,
    val id: UUID = UUID.randomUUID()
) : BaseEntity<UUID>(id)
