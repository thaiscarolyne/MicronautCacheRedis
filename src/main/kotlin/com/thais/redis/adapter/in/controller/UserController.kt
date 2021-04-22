package com.thais.redis.adapter.`in`.controller

import com.thais.redis.adapter.`in`.request.UserRequest
import com.thais.redis.adapter.`in`.response.UserResponse
import com.thais.redis.application.ports.`in`.GetUserByIdUseCase
import com.thais.redis.application.ports.`in`.UpdateUserUseCase
import io.micronaut.http.annotation.*

@Controller
class UserController(private val getUserByIdUseCase: GetUserByIdUseCase, private val updateUserUseCase: UpdateUserUseCase) {

    @Get("/user/{id}")
    fun getUserById(@PathVariable id : Long): String = getUserByIdUseCase.execute(id).name

    @Put("/user")
    fun updateUser(@Body userRequest: UserRequest): UserResponse {
        val user = updateUserUseCase.execute(userRequest.toDomain())

        return UserResponse(user)
    }
}