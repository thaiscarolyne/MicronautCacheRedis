package com.thais.redis.adapter.out.database.repository

import com.thais.redis.adapter.out.database.postgres.entity.UserEntity
import com.thais.redis.application.domain.User
import com.thais.redis.application.ports.out.UserRepositoryPort
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import io.micronaut.transaction.annotation.ReadOnly
import java.util.*
import javax.inject.Singleton
import javax.persistence.EntityManager

@Singleton
open class UserRepository(private val entityManager: EntityManager): UserRepositoryPort{

    @ReadOnly
    override fun getById(id: Long): User? {
        return entityManager.find(UserEntity::class.java, id)?.toDomain()
    }

}