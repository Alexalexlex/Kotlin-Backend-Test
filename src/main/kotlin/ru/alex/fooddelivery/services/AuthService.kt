package ru.alex.fooddelivery.services

import org.springframework.context.annotation.Bean
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.alex.fooddelivery.db.entity.UserEntity
import ru.alex.fooddelivery.db.entity.asNew
import ru.alex.fooddelivery.db.repository.UserRepository
import ru.alex.fooddelivery.dto.UserCreateDto
import ru.alex.fooddelivery.dto.UserDto
import ru.alex.fooddelivery.mappers.toDto
import java.io.IOException
@Service
class AuthService (
    val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
    ) {



    suspend fun create(user: UserCreateDto): UserDto {
        val userFromDB = userRepository.findByEmail(user.email);

        if (userFromDB != null) {
            throw IOException("User already exist");
            ;
        }

        user.password = passwordEncoder.encode(user.password);

        return userRepository.save(UserEntity(
            firstName = user.firstName,
            lastName = user.lastName,
            email = user.email,
            password = user.password,
        ).asNew()).toDto()
    }
}