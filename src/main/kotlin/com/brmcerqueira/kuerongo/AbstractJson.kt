package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.KuerongoConfig

@KuerongoMarker
abstract class AbstractJson {
    val raw = KuerongoConfig.kuerongoProvider.createJsonObject()

    infix fun <T> String.to(value: T) {
        raw.set(this, value)
    }

    protected fun <T : AbstractJson> to(key: String, builder:T, init: T.() -> Unit) {
        builder.init()
        if (!builder.raw.isEmpty) {
            raw.set(key, builder.raw)
        }
    }

    override fun toString(): String = raw.toString()
}
