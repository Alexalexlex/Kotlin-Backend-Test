package ru.alex.fooddelivery.db.entity
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("users")
data class UserEntity(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val id: UUID = UUID.randomUUID(),
): BaseEntity<UUID>(id)