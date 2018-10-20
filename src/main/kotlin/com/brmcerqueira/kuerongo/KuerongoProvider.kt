package com.brmcerqueira.kuerongo

abstract class KuerongoProvider {
    abstract fun createJsonObject(): IJsonObject
    abstract fun createJsonArray(): IJsonArray
}