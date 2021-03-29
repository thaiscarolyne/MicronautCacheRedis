package com.thais.redis.adapter.out.database.repository

import com.thais.redis.adapter.out.database.postgres.entity.UserEntity
import com.thais.redis.application.domain.User
import com.thais.redis.application.ports.out.UserRepositoryPort
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

class UserRepository: UserRepositoryPort{
    override fun getUserById(id: Long): User {
        TODO("Not yet implemented")
    }
}