package com.thais.redis.adapter.`in`.request

import com.thais.redis.application.domain.User

data class UserRequest(
    private val id : Long = 0L,
    private val name : String = ""
    ) {

    fun toDomain() : User =
        User(id, name)
}