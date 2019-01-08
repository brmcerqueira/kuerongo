package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.KuerongoConfig

@KuerongoMarker
abstract class AbstractJson : IRootJson {
    override val wrapper = KuerongoConfig.kuerongoProvider.createJsonObject()

    protected infix fun <T> String.set(value: T) {
        wrapper.set(this, value)
    }

    protected fun <T : AbstractJson> set(key: String, builder: T, init: T.() -> Unit) {
        builder.init()
        if (!builder.wrapper.isEmpty) {
            wrapper.set(key, builder)
        }
    }

    override fun toString(): String = wrapper.toString()
}
