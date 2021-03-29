package com.thais.redis.adapter.out.database.postgres.entity

import com.thais.redis.application.domain.User
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "USERS")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0L,

    @NotNull
    @Column
    val name: String = ""
){
    fun toDomain(): User {
        return User(id, name)
    }
}