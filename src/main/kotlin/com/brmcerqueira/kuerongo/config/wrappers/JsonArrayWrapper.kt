package com.brmcerqueira.kuerongo.config.wrappers

import com.brmcerqueira.kuerongo.config.IJsonArrayNative

class JsonArrayWrapper internal constructor(private val delegate: IJsonArrayNative) : JsonWrapper(delegate) {
    internal fun <T> add(value: T): JsonArrayWrapper {
        delegate.add(parse(value))
        return this
    }
}