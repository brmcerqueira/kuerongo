package com.brmcerqueira.kuerongo.config

interface IJsonObject {
    val isEmpty: Boolean
    fun <T : Any?> putUsingMapper(key: String, value: T): IJsonObject
}