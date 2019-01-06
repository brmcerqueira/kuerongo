package com.brmcerqueira.kuerongo

class JsonArray : AbstracJsonArray() {
    fun <T> put(vararg values: T): JsonArray {
        values.forEach(::add)
        return this
    }
}