package com.thais.redis.base

import com.thais.redis.application.domain.User
import com.thais.redis.base.DefaultConstants.ID
import com.thais.redis.base.DefaultConstants.NAME

class UserTestBuilder {

    private var id: Long = ID
    private var name: String = NAME

    companion object {
        fun aUser() = UserTestBuilder()

        fun aUserWithIdZero() = UserTestBuilder().setId(0)

        fun aUserWithNoName() = UserTestBuilder().setName("")
    }

    private fun setId(id: Long): UserTestBuilder{
        this.id = id
        return this
    }

    private fun setName(name: String): UserTestBuilder{
        this.name = name
        return this
    }

    fun build() = User(id, name)
}