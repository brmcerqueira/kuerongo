package com.brmcerqueira.kuerongo

@JsonMarker
abstract class JsonRootBuilder(protected val kuerongoProvider: KuerongoProvider) {
    val json = kuerongoProvider.createJsonObject()

    infix fun <T> String.to(value: T) {
        json.putUsingMapper(this, value)
    }

    protected fun <T : JsonRootBuilder> to(key: String, builder:T, init: T.() -> Unit) {
        builder.init()
        if (!builder.json.isEmpty) {
            json.putUsingMapper(key, builder.json)
        }
    }
}
