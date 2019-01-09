package com.brmcerqueira.kuerongo

class JsonArray : AbstractJsonArray() {
    fun <T> put(vararg values: T): JsonArray {
        values.forEach(::add)
        return this
    }
}