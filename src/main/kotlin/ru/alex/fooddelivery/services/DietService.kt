package ru.alex.fooddelivery.services

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service
import ru.alex.fooddelivery.db.entity.DietEntity
import ru.alex.fooddelivery.db.entity.asNew
import ru.alex.fooddelivery.db.repository.DietRepository
import ru.alex.fooddelivery.dto.DietCreateDto
import ru.alex.fooddelivery.dto.DietDto
import ru.alex.fooddelivery.dto.DietUpdateDto
import ru.alex.fooddelivery.mappers.toDto
import java.time.Instant
import java.util.*

@Service
class DietService(
    val dietRepository: DietRepository
) {
    suspend fun create(diet: DietCreateDto): DietDto {
        return dietRepository.save(DietEntity(
            title = diet.title,
            description = diet.description,
            image = diet.image,
        ).asNew()).toDto()
    }

    suspend fun update(diet: DietUpdateDto): DietDto {
        val dietEntity = dietRepository.findOneByDeletedAtIsNull(diet.id) ?: throw RuntimeException("Diet not found")

        return dietRepository.save(dietEntity.copy(
            title = diet.title ?: dietEntity.title,
            description = diet.description ?: dietEntity.description,
            image = diet.image ?: dietEntity.image,
            updatedAt = Instant.now()
        )).toDto()
    }

    suspend fun delete(id: UUID) {
        dietRepository.findOneByDeletedAtIsNull(id) ?: throw RuntimeException("Diet not found")
        dietRepository.deleteById(id)
    }

    suspend fun getAll(): Flow<DietDto> {
        return dietRepository.findAllByDeletedAtIsNull().map { it.toDto() }
    }

    suspend fun getById(id: UUID): DietDto? {
        return dietRepository.findOneByDeletedAtIsNull(id)?.toDto()
    }
}