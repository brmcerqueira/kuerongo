package com.brmcerqueira.kuerongo.config.wrappers

import com.brmcerqueira.kuerongo.IRootJson
import com.brmcerqueira.kuerongo.config.IJsonNative

abstract class JsonWrapper internal constructor(private val delegate: IJsonNative) : IJsonWrapper {
    internal val isEmpty: Boolean
        get() = delegate.isEmpty

    protected fun parse(value: Any?) : Any? = when (value) {
        is String -> "\"$value\""
        is IRootJson -> value.wrapper
        else -> value
    }

    override fun toString(): String = delegate.toString()
}