package com.thais.redis.application.ports.out

import com.thais.redis.application.domain.User

interface UserRepositoryPort {

    fun getUserById(id: Long): User
}