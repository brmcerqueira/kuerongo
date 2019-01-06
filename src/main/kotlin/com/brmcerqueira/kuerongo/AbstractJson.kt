package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.KuerongoConfig

@KuerongoMarker
abstract class AbstractJson {
    val json = KuerongoConfig.kuerongoProvider.createJsonObject()

    infix fun <T> String.to(value: T) {
        json.putUsingMapper(this, value)
    }

    protected fun <T : AbstractJson> to(key: String, builder:T, init: T.() -> Unit) {
        builder.init()
        if (!builder.json.isEmpty) {
            json.putUsingMapper(key, builder.json)
        }
    }
}
