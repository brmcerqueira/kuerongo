package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.KuerongoConfig

@KuerongoMarker
abstract class AbstracJsonArray {
    val raw = KuerongoConfig.kuerongoProvider.createJsonArray()

    protected fun add(json: Json) = raw.add(json.raw)
}
