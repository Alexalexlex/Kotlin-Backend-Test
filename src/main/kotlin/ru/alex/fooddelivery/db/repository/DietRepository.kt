package ru.alex.fooddelivery.db.repository

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository
import ru.alex.fooddelivery.db.entity.DietEntity
import java.util.*

@Repository
interface DietRepository : CoroutineCrudRepository<DietEntity, UUID> {
    fun findAllByDeletedAtIsNull(): Flow<DietEntity>
    suspend fun findOneByDeletedAtIsNull(id: UUID): DietEntity?

    @Query("UPDATE diets SET deleted_at = CURRENT_TIMESTAMP WHERE id = :id")
    override suspend fun deleteById(id: UUID)

    @Query("UPDATE diets SET deleted_at = NULL WHERE id = :id")
    suspend fun restoreById(id: UUID): DietEntity
}