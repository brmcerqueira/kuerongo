package com.brmcerqueira.kuerongo

class JsonArray() : AbstractJsonArray() {
    constructor(vararg values: Any) : this() {
        values.forEach(::add)
    }

    fun <T> put(vararg values: T): JsonArray {
        values.forEach(::add)
        return this
    }
}