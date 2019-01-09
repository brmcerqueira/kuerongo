package com.brmcerqueira.kuerongo.config

import com.brmcerqueira.kuerongo.wrappers.JsonArrayWrapper
import com.brmcerqueira.kuerongo.wrappers.JsonObjectWrapper
import java.lang.UnsupportedOperationException

class KuerongoConfig {
    companion object {
        private var instance: IKuerongoProvider? = null
            get() = if (field == null) {
                field = DefaultKuerongoProvider()
                field!!
            } else field!!
            set(value) {
                if (field == null) {
                    field = value
                }
                else throw UnsupportedOperationException()
            }

        fun use(provider: IKuerongoProvider) {
            instance = provider
        }

        internal fun createJsonObject() = JsonObjectWrapper(instance!!.createJsonObject())
        internal fun createJsonArray() = JsonArrayWrapper(instance!!.createJsonArray())
    }
}