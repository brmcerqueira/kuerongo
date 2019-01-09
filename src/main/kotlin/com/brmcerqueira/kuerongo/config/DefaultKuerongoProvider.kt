package com.brmcerqueira.kuerongo.config


class DefaultKuerongoProvider : IKuerongoProvider {
    override fun createJsonObject(): IJsonObjectNative = object : IJsonObjectNative {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> set(key: String, value: T) {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append("\"$key\":$value")
        }

        override fun toString(): String = "{$stringBuilder}"
    }

    override fun createJsonArray(): IJsonArrayNative = object : IJsonArrayNative {
        private val stringBuilder = StringBuilder()

        override val isEmpty: Boolean
        get() = stringBuilder.isEmpty()

        override fun <T> add(value: T) {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append(value)
        }

        override fun toString(): String = "[$stringBuilder]"
    }
}