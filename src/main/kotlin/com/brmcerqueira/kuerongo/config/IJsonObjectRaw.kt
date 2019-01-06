package com.brmcerqueira.kuerongo.config

interface IJsonObjectRaw : IJsonRaw {
    fun <T : Any?> set(key: String, value: T): IJsonObjectRaw
}