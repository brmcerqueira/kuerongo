package com.brmcerqueira.kuerongo


class StringExpression(private var value: String) : IExpression {
    @Suppress("UNCHECKED_CAST")
    override fun <T> raw(): T = value as T

    fun prefix(text: String): StringExpression {
        value = "$text$value"
        return this
    }

    fun suffix(text: String): StringExpression {
        value = "$value$text"
        return this
    }

    override fun toString(): String {
        return value
    }
}