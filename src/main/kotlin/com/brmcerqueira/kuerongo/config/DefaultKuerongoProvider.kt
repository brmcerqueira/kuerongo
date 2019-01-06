package com.brmcerqueira.kuerongo.config

import com.brmcerqueira.kuerongo.IRootJson

class DefaultKuerongoProvider : IKuerongoProvider {
    override fun createJsonObject(): IJsonObjectRaw = JsonObject(::parse)

    override fun createJsonArray(): IJsonArrayRaw = JsonArray(::parse)

    override fun createLiteral(value: Any?): IJsonRaw = Literal(parse(value))

    private fun parse(value: Any?) : String = when (value) {
        is String -> "\"$value\""
        is IRootJson -> value.raw.toString()
        else -> value.toString()
    }

    private class Literal(private val value: Any?) : IJsonRaw {
        override val isEmpty: Boolean
            get() = false

        override fun toString(): String = value.toString()
    }

    private class JsonObject(private val parse: (Any?) -> String) : IJsonObjectRaw {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> set(key: String, value: T): IJsonObjectRaw {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append("\"$key\":${parse(value)}")
            return this
        }

        override fun toString(): String = "{$stringBuilder}"
    }

    private class JsonArray(private val parse: (Any?) -> String) : IJsonArrayRaw {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> add(value: T): IJsonArrayRaw {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append(parse(value))
            return this
        }

        override fun toString(): String = "[$stringBuilder]"
    }
}