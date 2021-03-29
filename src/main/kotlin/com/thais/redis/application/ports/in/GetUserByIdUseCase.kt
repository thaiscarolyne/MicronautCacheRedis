package com.thais.redis.application.ports.`in`

import com.thais.redis.application.domain.User

interface GetUserByIdUseCase {

    fun execute(id: Long): User
}