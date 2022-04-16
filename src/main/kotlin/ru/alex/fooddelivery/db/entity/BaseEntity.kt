package ru.alex.fooddelivery.db.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import java.io.Serializable

abstract class BaseEntity<ID>(
    private val id: ID
) : Persistable<ID>, Serializable {
    @Transient
    private var isNew = false

    @Id
    override fun getId() = id

    override fun isNew() = isNew

    fun markNew() {
        isNew = true
    }
}

fun <ID, T : BaseEntity<ID>> T.asNew(): T {
    this.markNew()
    return this
}
