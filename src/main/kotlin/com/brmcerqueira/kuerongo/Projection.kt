package com.brmcerqueira.kuerongo

class Projection(kuerongoProvider: KuerongoProvider) : Expression(kuerongoProvider) {
    operator fun String.unaryPlus() {
        json.putUsingMapper(this, true)
    }

    operator fun String.unaryMinus() {
        json.putUsingMapper(this, false)
    }

    infix fun String.to(init: Projection.() -> Unit) = to(this, Projection(kuerongoProvider), init)
}
