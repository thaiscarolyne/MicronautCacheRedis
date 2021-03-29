package com.thais.redis.application.service

import com.thais.redis.application.domain.User
import com.thais.redis.application.ports.`in`.GetUserByIdUseCase
import com.thais.redis.application.ports.out.UserRepositoryPort
import javax.inject.Singleton

@Singleton
class GetUserByIdService(private val userRepositoryPort: UserRepositoryPort): GetUserByIdUseCase {
    override fun execute(id: Long): User =
        userRepositoryPort.getById(id)
            ?: throw Exception("No user with this id was found!")
}