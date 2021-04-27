package com.thais.redis.adapter.`in`.response

import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.thais.redis.application.domain.User

data class UserResponse(
    val id : Long,
    val name : String
) {
    constructor(user: User): this(user.id, user.name)
}