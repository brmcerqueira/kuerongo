package com.brmcerqueira.kuerongo

internal class Expression() : AbstractJson(), IExpression {
    constructor(init: Expression.() -> Unit) : this() {
        init()
    }

    infix fun <T> String.to(value: T) = this.set(value)

    infix fun String.to(init: Json.() -> Unit) = set(this, Json(), init)
}