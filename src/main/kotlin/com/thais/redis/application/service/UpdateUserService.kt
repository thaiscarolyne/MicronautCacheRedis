package com.thais.redis.application.service

import com.thais.redis.application.domain.User
import com.thais.redis.application.ports.`in`.UpdateUserUseCase
import com.thais.redis.application.ports.out.UserRepositoryPort
import com.thais.redis.infra.cache.UserKeyGenerator
import io.micronaut.cache.annotation.CacheConfig
import io.micronaut.cache.annotation.CacheInvalidate
import javax.inject.Singleton

@Singleton
@CacheConfig
open class UpdateUserService(private val userRepositoryPort: UserRepositoryPort): UpdateUserUseCase {

    @CacheInvalidate(value = ["user"], keyGenerator = UserKeyGenerator::class)
    override fun execute(user: User): User =
        userRepositoryPort.update(user)
            ?: throw Exception("No user with this id was found to be updated")

}