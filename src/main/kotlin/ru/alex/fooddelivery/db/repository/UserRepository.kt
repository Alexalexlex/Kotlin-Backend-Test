package ru.alex.fooddelivery.db.repository

import kotlinx.coroutines.flow.Flow
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import ru.alex.fooddelivery.db.entity.UserEntity
import java.util.*

@Repository
interface UserRepository: CoroutineCrudRepository<UserEntity, UUID> {
    fun save(user: UserEntity): Flow<UserEntity>
}