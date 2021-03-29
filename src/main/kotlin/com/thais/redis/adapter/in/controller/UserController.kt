package com.thais.redis.adapter.`in`.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable

@Controller
class UserController {

    @Get("/user/{id}")
    fun getUserById(@PathVariable id : Long){

    }
}