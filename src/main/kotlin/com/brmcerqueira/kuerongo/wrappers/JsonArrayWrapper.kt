package com.brmcerqueira.kuerongo.wrappers

class JsonArrayWrapper internal constructor(native: IJsonArrayNativeWrapper) : JsonWrapper<IJsonArrayNativeWrapper>(native) {
    internal fun <T> add(value: T): JsonArrayWrapper {
        protectedNative.add(parse(value))
        return this
    }
}