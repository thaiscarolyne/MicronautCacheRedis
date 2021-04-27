package com.thais.redis.adapter.`in`.request

import com.thais.redis.application.domain.User

data class UserRequest(
    val id : Long = 0L,
    val name : String = ""
    ) {

    fun toDomain() : User =
        User(id, name)
}