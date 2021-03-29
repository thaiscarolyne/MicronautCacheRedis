package com.thais.redis.adapter.`in`.controller

import com.thais.redis.application.ports.`in`.GetUserByIdUseCase
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller
class UserController(private val getUserByIdUseCase: GetUserByIdUseCase) {

    @Get("/user/{id}")
    fun getUserById(@PathVariable id : Long): String = getUserByIdUseCase.execute(id).name

}