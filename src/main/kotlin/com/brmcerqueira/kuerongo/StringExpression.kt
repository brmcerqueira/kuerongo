package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.IJsonRaw

class StringExpression(private val value: String) : IExpression {
    override val raw: IJsonRaw
        get() = StringJsonRaw(value)

    private class StringJsonRaw(private val value: String) : IJsonRaw {
        override val isEmpty: Boolean
            get() = false

        override fun toString(): String = "\"$value\""
    }
}