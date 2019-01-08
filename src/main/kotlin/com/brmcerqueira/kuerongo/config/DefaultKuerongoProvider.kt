package com.brmcerqueira.kuerongo.config

import com.brmcerqueira.kuerongo.IRootJson

class DefaultKuerongoProvider : IKuerongoProvider {
    override fun createJsonObject(): IJsonObjectWrapper = JsonObjectWrapper(::parse)

    override fun createJsonArray(): IJsonArrayWrapper = JsonArrayWrapper(::parse)

    private fun parse(value: Any?) : String = when (value) {
        is String -> "\"$value\""
        is IRootJson -> value.wrapper.toString()
        else -> value.toString()
    }

    private class JsonObjectWrapper(private val parse: (Any?) -> String) : IJsonObjectWrapper {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> set(key: String, value: T): IJsonObjectWrapper {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append("\"$key\":${parse(value)}")
            return this
        }

        override fun toString(): String = "{$stringBuilder}"
    }

    private class JsonArrayWrapper(private val parse: (Any?) -> String) : IJsonArrayWrapper {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> add(value: T): IJsonArrayWrapper {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append(parse(value))
            return this
        }

        override fun toString(): String = "[$stringBuilder]"
    }
}