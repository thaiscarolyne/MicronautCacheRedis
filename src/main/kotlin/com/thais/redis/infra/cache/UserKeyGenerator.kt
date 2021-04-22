package com.thais.redis.infra.cache

import com.thais.redis.application.domain.User
import io.micronaut.cache.interceptor.DefaultCacheKeyGenerator
import io.micronaut.core.annotation.AnnotationMetadata

class UserKeyGenerator : DefaultCacheKeyGenerator() {

    override fun generateKey(annotationMetadata: AnnotationMetadata?, vararg params: Any?): Any {
        return params.firstOrNull { it is User }?.let { it as User }?.id
            ?: super.generateKey(annotationMetadata, *params)
    }
}