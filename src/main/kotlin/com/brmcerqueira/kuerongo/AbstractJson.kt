package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.KuerongoConfig

@KuerongoMarker
abstract class AbstractJson : IRootJson {
    override val raw = KuerongoConfig.kuerongoProvider.createJsonObject()

    protected infix fun <T> String.set(value: T) {
        raw.set(this, value)
    }

    protected fun <T : AbstractJson> set(key: String, builder: T, init: T.() -> Unit) {
        builder.init()
        if (!builder.raw.isEmpty) {
            raw.set(key, builder)
        }
    }

    override fun toString(): String = raw.toString()
}
