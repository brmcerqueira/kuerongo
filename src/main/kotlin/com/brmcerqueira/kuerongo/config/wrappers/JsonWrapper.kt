package com.brmcerqueira.kuerongo.config.wrappers

import com.brmcerqueira.kuerongo.IRootJson

abstract class JsonWrapper<T : IJsonNativeWrapper> internal constructor(protected val protectedNative: T) : IJsonWrapper {
    val isEmpty: Boolean
        get() = protectedNative.isEmpty

    protected fun parse(value: Any?) : Any? = when (value) {
        is String -> "\"$value\""
        is IRootJson -> value.raw()
        else -> value
    }

    override val nativeWrapper: IJsonNativeWrapper
        get() = protectedNative

    override fun toString(): String = protectedNative.toString()
}