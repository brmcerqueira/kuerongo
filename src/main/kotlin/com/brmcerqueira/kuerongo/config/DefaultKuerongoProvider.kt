package com.brmcerqueira.kuerongo.config

class DefaultKuerongoProvider : IKuerongoProvider {
    override fun createJsonObject(): IJsonObject = JsonObject(::parse)

    override fun createJsonArray(): IJsonArray = JsonArray(::parse)

    private fun  parse(value: Any?) : String = when (value) {
        is String -> "\"$value\""
        else -> value.toString()
    }

    private class JsonObject(private val parse: (Any?) -> String) : IJsonObject {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> putUsingMapper(key: String, value: T): IJsonObject {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append("\"$key\":${parse(value)}")
            return this
        }

        override fun toString(): String = "{$stringBuilder}"
    }

    private class JsonArray(private val parse: (Any?) -> String) : IJsonArray {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> addUsingMapper(value: T): IJsonArray {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append(parse(value))
            return this
        }

        override fun toString(): String = "[$stringBuilder]"
    }
}