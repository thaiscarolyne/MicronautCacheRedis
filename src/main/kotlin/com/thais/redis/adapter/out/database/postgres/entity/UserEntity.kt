package com.thais.redis.adapter.out.database.postgres.entity

import com.thais.redis.application.domain.User
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Table

@Entity
@Table(name = "USER")
data class UserEntity(
    @Column
    @GeneratedValue
    val id: Long,

    @Column
    val name: String
) {
    fun toDomain(): User {
        return User(id, name)
    }
}