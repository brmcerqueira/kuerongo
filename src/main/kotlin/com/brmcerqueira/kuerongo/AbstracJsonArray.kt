package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.KuerongoConfig

@KuerongoMarker
abstract class AbstracJsonArray {
    val raw = KuerongoConfig.kuerongoProvider.createJsonArray()

    protected fun add(json: AbstractJson) = raw.add(json.raw)
}
