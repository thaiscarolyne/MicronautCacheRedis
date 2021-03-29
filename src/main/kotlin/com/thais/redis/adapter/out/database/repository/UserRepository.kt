package com.thais.redis.adapter.out.database.repository

import com.thais.redis.application.domain.User
import com.thais.redis.application.ports.out.UserRepositoryPort

class UserRepository: UserRepositoryPort{
    override fun getUserById(id: Long): User {
        TODO("Not yet implemented")
    }
}