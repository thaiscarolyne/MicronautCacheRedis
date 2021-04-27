package com.thais.redis.infra.cache

import com.thais.redis.application.domain.User
import io.micronaut.cache.interceptor.DefaultCacheKeyGenerator
import io.micronaut.core.annotation.AnnotationMetadata

class UserKeyGenerator : DefaultCacheKeyGenerator() {
    //This key generation is necessary because if it's not done, it will try to invalidate
    //a key that matches all the user object received at the method, and actually, our key is just the id
    override fun generateKey(annotationMetadata: AnnotationMetadata?, vararg params: Any?): Any {
        return params.firstOrNull { it is User }?.let { it as User }?.id
            ?: super.generateKey(annotationMetadata, *params)
    }
}