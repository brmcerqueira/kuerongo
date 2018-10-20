package com.brmcerqueira.kuerongo

@JsonMarker
abstract class JsonArrayBuilder(protected val kuerongoProvider: KuerongoProvider) {
    val json = kuerongoProvider.createJsonArray()

    protected fun add(jsonBuilder: JsonBuilder) = json.addUsingMapper(jsonBuilder.json)
}
