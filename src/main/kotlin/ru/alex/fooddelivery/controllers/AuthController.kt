package ru.alex.fooddelivery.controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.alex.fooddelivery.dto.DietDto
import ru.alex.fooddelivery.dto.UserCreateDto
import javax.validation.Valid

@RestController
class AuthController {

    @PostMapping("signup")
    suspend fun create(@Valid @RequestBody user: UserCreateDto): DietDto {
        return authService.create(user)
    }

}