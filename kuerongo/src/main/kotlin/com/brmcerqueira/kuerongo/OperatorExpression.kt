package com.brmcerqueira.kuerongo

internal class OperatorExpression() : AbstractJson(), IExpression {
    constructor(init: OperatorExpression.() -> Unit) : this() {
        init()
    }

    operator fun <T> String.timesAssign(value: T) = this.set(value)

    operator fun String.timesAssign(init: Json.() -> Unit) = set(this, Json(), init)
}