package com.brmcerqueira.kuerongo.config

interface IJsonObjectRaw {
    val isEmpty: Boolean
    fun <T : Any?> set(key: String, value: T): IJsonObjectRaw
}