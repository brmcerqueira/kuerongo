package com.brmcerqueira.kuerongo

open class Query(kuerongoProvider: KuerongoProvider) : Expression(kuerongoProvider) {
    infix fun String.to(init: Query.() -> Unit) = to(this, Query(kuerongoProvider), init)
}
