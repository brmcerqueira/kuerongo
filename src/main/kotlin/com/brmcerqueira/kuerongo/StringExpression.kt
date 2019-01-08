package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.IJsonWrapper

class StringExpression(private val value: String) : IExpression {
    override val wrapper: IJsonWrapper
        get() = StringJsonWrapper(value)

    private class StringJsonWrapper(private val value: String) : IJsonWrapper {
        override val isEmpty: Boolean
            get() = false

        override fun toString(): String = "\"$value\""
    }
}