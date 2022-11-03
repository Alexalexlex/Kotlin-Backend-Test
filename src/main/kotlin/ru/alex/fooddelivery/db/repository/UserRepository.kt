package ru.alex.fooddelivery.db.repository

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import ru.alex.fooddelivery.db.entity.DietEntity
import ru.alex.fooddelivery.db.entity.UserEntity
import java.util.*

@Repository
interface UserRepository: CoroutineCrudRepository<UserEntity, UUID> {
    suspend fun findByEmail(email: String): UserEntity?
}