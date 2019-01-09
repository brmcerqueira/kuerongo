package com.brmcerqueira.kuerongo.config

interface IJsonObjectNative : IJsonNative {
    fun <T : Any?> set(key: String, value: T)
}