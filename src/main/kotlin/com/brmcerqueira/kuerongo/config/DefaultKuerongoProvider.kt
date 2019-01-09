package com.brmcerqueira.kuerongo.config

import com.brmcerqueira.kuerongo.wrappers.IJsonArrayNativeWrapper
import com.brmcerqueira.kuerongo.wrappers.IJsonObjectNativeWrapper

class DefaultKuerongoProvider : IKuerongoProvider {
    override fun createJsonObject(): IJsonObjectNativeWrapper = object : IJsonObjectNativeWrapper {
        private val stringBuilder = StringBuilder()

        override val raw: Any
            get() = toString()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> set(key: String, value: T) {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append("\"$key\":$value")
        }

        override fun toString(): String = "{$stringBuilder}"
    }

    override fun createJsonArray(): IJsonArrayNativeWrapper = object : IJsonArrayNativeWrapper {
        private val stringBuilder = StringBuilder()

        override val raw: Any
            get() = toString()

        override val isEmpty: Boolean
            get() = stringBuilder.isEmpty()

        override fun <T> add(value: T) {
            if (stringBuilder.isNotEmpty()) stringBuilder.append(",")
            stringBuilder.append(value)
        }

        override fun toString(): String = "[$stringBuilder]"
    }
}