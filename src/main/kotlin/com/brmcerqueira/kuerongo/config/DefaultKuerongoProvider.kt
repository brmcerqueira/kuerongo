package com.brmcerqueira.kuerongo.config

class DefaultKuerongoProvider : IKuerongoProvider {
    override fun createJsonObject(): IJsonObject = JsonObject()

    override fun createJsonArray(): IJsonArray = JsonArray()

    private class JsonObject : IJsonObject {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> putUsingMapper(key: String, value: T): IJsonObject {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append("$key:$value")
            return this
        }

        override fun toString(): String = "{$stringBuilder}"
    }

    private class JsonArray : IJsonArray {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> addUsingMapper(value: T): IJsonArray {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append(value)
            return this
        }

        override fun toString(): String = "[$stringBuilder]"
    }
}