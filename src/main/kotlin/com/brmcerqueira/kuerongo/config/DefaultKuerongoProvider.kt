package com.brmcerqueira.kuerongo.config

import com.brmcerqueira.kuerongo.wrappers.IJsonArrayNativeWrapper
import com.brmcerqueira.kuerongo.wrappers.IJsonObjectNativeWrapper

class DefaultKuerongoProvider : IKuerongoProvider {

    private fun <T> parse(value: T) : Any? = when (value) {
        is String -> "\"$value\""
        else -> value
    }

    override fun createJsonObject(): IJsonObjectNativeWrapper = object : IJsonObjectNativeWrapper {
        private val stringBuilder = StringBuilder()

        override val raw: Any
            get() = this

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> set(key: String, value: T) {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append("\"$key\":${parse(value)}")
        }

        override fun toString(): String = "{$stringBuilder}"
    }

    override fun createJsonArray(): IJsonArrayNativeWrapper = object : IJsonArrayNativeWrapper {
        private val stringBuilder = StringBuilder()

        override val raw: Any
            get() = this

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> add(value: T) {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append(parse(value))
        }

        override fun toString(): String = "[$stringBuilder]"
    }
}