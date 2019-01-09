package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.wrappers.IJsonWrapper

class StringExpression(private val value: String) : IExpression {
    override val wrapper: IJsonWrapper
        get() = object : IJsonWrapper {
            override fun toString(): String = "\"$value\""
        }
}