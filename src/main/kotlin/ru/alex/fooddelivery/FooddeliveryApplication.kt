package ru.alex.fooddelivery

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.Random
import java.util.UUID

@SpringBootApplication
class FoodDeliveryApplication

fun main(args: Array<String>) {
    runApplication<FoodDeliveryApplication>(*args)
//    val arr = listOf(Clazz.success(), Clazz.success(), Clazz.notFound(), Clazz.notFound())
//    val (p1, p2) = arr.partition { it.i % 2 == 0 }
//    val map = arr.groupBy { it.type }
//
//
//
//
//    val x = 0
}

enum class HttpStatus(val status: Int) {
    SUCCESS(200),
    NOT_FOUND(404)
}

data class Clazz(
    val id: UUID = UUID.randomUUID(),
    val i: Int = random.nextInt(0, 10),
    val type: HttpStatus
) {
    companion object {
        private val random = Random()
        fun success() = Clazz(type = HttpStatus.SUCCESS)
        fun notFound() = Clazz(type = HttpStatus.NOT_FOUND)
    }
}