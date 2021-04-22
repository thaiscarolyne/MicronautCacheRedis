package com.thais.redis.application.ports.`in`

import com.thais.redis.application.domain.User

interface UpdateUserUseCase {

    fun execute(user: User): User
}