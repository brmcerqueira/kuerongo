package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.KuerongoConfig

@KuerongoMarker
abstract class AbstracJsonArray : IRootJson {
    override val raw = KuerongoConfig.kuerongoProvider.createJsonArray()

    protected fun <T> add(value: T) {
        raw.add(value)
    }

    override fun toString(): String = raw.toString()
}
