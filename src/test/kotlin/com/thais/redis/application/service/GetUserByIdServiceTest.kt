package com.thais.redis.application.service

import com.thais.redis.application.domain.User
import com.thais.redis.application.ports.out.UserRepositoryPort
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GetUserByIdServiceTest {

    @MockK
    private lateinit var userRepositoryPort: UserRepositoryPort

    @InjectMockKs
    private lateinit var getUserByIdService: GetUserByIdService

    @Test
    fun `Execute should return a User if it exists at database`(){
        //GIVEN
        val id = 1L
        val name = "Maria"
        val responseExpected = User(id, name)
        every { userRepositoryPort.getById(id) } returns responseExpected

        //WHEN
        val responseReceived = getUserByIdService.execute(id)

        //THEN
        assert(responseReceived == responseExpected)
    }
}

