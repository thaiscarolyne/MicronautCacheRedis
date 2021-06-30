package com.thais.redis.application.service

import com.thais.redis.application.domain.User
import com.thais.redis.application.ports.`in`.GetUserByIdUseCase
import com.thais.redis.application.ports.out.UserRepositoryPort
import io.micronaut.cache.annotation.CacheConfig
import io.micronaut.cache.annotation.Cacheable
import javax.inject.Singleton

@Singleton
@CacheConfig
open class GetUserByIdService(private val userRepositoryPort: UserRepositoryPort): GetUserByIdUseCase {

    @Cacheable(value = ["user"])
    override fun execute(id: Long): User =
        userRepositoryPort.getById(id)
            ?: throw Exception("No user with this id was found!")
}

