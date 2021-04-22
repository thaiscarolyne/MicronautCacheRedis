package com.thais.redis.application.ports.out

import com.thais.redis.application.domain.User

interface UserRepositoryPort {

    fun getById(id: Long): User?

    fun update(user: User): User?
}