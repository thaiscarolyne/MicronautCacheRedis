package com.thais.redis.adapter.out.database.repository

import com.thais.redis.adapter.out.database.postgres.entity.UserEntity
import com.thais.redis.application.domain.User
import com.thais.redis.application.ports.out.UserRepositoryPort
import io.micronaut.transaction.annotation.ReadOnly
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Singleton
open class UserRepository(private val entityManager: EntityManager): UserRepositoryPort{

    @ReadOnly
    override fun getById(id: Long): User? {
        return entityManager.find(UserEntity::class.java, id)?.toDomain()
    }

    @Transactional
    override fun update(user: User): User? {
        val numberUsersUpdated = entityManager.createQuery("UPDATE UserEntity SET name = :name where id = :id")
            .setParameter("name", user.name)
            .setParameter("id", user.id)
            .executeUpdate();

        return when(numberUsersUpdated == 1) {
            true -> {
                user
            }
            false -> {
                null
            }
        }
    }

}