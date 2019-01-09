package com.brmcerqueira.kuerongo.config.wrappers

class JsonObjectWrapper internal constructor(native: IJsonObjectNativeWrapper) : JsonWrapper<IJsonObjectNativeWrapper>(native) {
    internal fun <T> set(key: String, value: T): JsonObjectWrapper {
        protectedNative.set(key, parse(value))
        return this
    }
}