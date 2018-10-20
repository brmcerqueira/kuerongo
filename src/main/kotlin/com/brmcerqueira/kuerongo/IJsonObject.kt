package com.brmcerqueira.kuerongo

interface IJsonObject {
    val isEmpty: Boolean
    fun <T : Any?> putUsingMapper(key: String, value: T): IJsonObject
}