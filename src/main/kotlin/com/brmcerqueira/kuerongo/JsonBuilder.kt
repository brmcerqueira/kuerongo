package com.brmcerqueira.kuerongo

class JsonBuilder(kuerongoProvider: KuerongoProvider) : JsonRootBuilder(kuerongoProvider) {

    constructor(kuerongoProvider: KuerongoProvider, init: JsonBuilder.() -> Unit) : this(kuerongoProvider) {
        init()
    }

    infix fun String.to(init: JsonBuilder.() -> Unit) = to(this, JsonBuilder(kuerongoProvider), init)
}
