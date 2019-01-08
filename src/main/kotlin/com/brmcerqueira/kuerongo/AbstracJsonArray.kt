package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.KuerongoConfig

@KuerongoMarker
abstract class AbstracJsonArray : IRootJson {
    override val wrapper = KuerongoConfig.kuerongoProvider.createJsonArray()

    protected fun <T> add(value: T) {
        wrapper.add(value)
    }

    override fun toString(): String = wrapper.toString()
}
