package ru.alex.fooddelivery.controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.alex.fooddelivery.dto.UserCreateDto
import ru.alex.fooddelivery.dto.UserDto
import ru.alex.fooddelivery.services.AuthService
import javax.validation.Valid

@RestController
@RequestMapping(path = ["/auth"])
class AuthController (val authService: AuthService) {

    @PostMapping("signup")
    suspend fun create(@Valid @RequestBody user: UserCreateDto): UserDto {
        return authService.create(user)
    }

}