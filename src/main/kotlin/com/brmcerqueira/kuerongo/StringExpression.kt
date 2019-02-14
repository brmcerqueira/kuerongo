package com.brmcerqueira.kuerongo


class StringExpression(private val value: String) : IExpression {
    @Suppress("UNCHECKED_CAST")
    override fun <T> raw(): T = value as T
}