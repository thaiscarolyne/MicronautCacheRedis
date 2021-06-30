package com.thais.redis.application.service

import com.thais.redis.application.domain.User
import com.thais.redis.application.ports.out.UserRepositoryPort
import com.thais.redis.base.UserTestBuilder
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class UpdateUserServiceTest {

    @MockK
    private lateinit var userRepositoryPort: UserRepositoryPort

    @InjectMockKs
    private lateinit var updateUserService: UpdateUserService

    @Test
    fun `Execute should return a User if it exists at database and was updated`(){
        //GIVEN
        val user = UserTestBuilder.aUser().build()
        every { userRepositoryPort.update(user) } returns user

        //WHEN
        val responseReceived = updateUserService.execute(user)

        //THEN
        assert(responseReceived == user)
    }
}