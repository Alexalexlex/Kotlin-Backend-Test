package ru.alex.fooddelivery.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.support.WebExchangeBindException
import java.time.Instant
import java.util.Locale

@ControllerAdvice
class ErrorsController {
    data class ExceptionResponse(
        val timestamp: String,
        val message: String?
    )

    @ExceptionHandler(RuntimeException::class)
    fun handle(exception: RuntimeException): ResponseEntity<*> {
        val message = if (exception is WebExchangeBindException) {
            exception.fieldErrors.firstOrNull()?.defaultMessage
        } else {
            exception.message
        }

        return ResponseEntity.status(500).body(
            ExceptionResponse(
                timestamp = Instant.now().toString(),
                message = message
            )
        )
    }
}

