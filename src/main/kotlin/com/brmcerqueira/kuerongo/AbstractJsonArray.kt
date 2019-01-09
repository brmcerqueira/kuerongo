package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.KuerongoConfig
import com.brmcerqueira.kuerongo.wrappers.JsonArrayWrapper

@KuerongoMarker
abstract class AbstractJsonArray : AbstractRoot<JsonArrayWrapper>(KuerongoConfig.createJsonArray()) {
    protected fun <T> add(value: T) {
        wrapper.add(value)
    }

    override fun toString(): String = wrapper.toString()
}
