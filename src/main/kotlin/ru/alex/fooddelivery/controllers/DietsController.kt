package ru.alex.fooddelivery.controllers

import kotlinx.coroutines.flow.Flow
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.*
import ru.alex.fooddelivery.dto.DietCreateDto
import ru.alex.fooddelivery.dto.DietDto
import ru.alex.fooddelivery.dto.DietUpdateDto
import ru.alex.fooddelivery.services.DietService
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/diets"])
class DietsController(
    val dietService: DietService
) {
    @PostMapping
    suspend fun create(@Valid @RequestBody diet: DietCreateDto): DietDto {
        return dietService.create(diet)
    }

    @PatchMapping
    suspend fun update(@Valid @RequestBody diet: DietUpdateDto): DietDto {
        return dietService.update(diet)
    }

    @DeleteMapping("/{id}")
    suspend fun delete(@PathVariable id: UUID) {
        dietService.delete(id)
    }

    @GetMapping
    suspend fun getAll(): Flow<DietDto> {
        return dietService.getAll()
    }

    @GetMapping("/{id}")
    suspend fun getById(@PathVariable id: UUID): DietDto? {
        return dietService.getById(id)
    }
}

