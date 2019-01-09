package com.brmcerqueira.kuerongo.config.wrappers

import com.brmcerqueira.kuerongo.config.IJsonObjectNative

class JsonObjectWrapper internal constructor(private val delegate: IJsonObjectNative) : JsonWrapper(delegate) {
    internal fun <T> set(key: String, value: T): JsonObjectWrapper {
        delegate.set(key, parse(value))
        return this
    }
}