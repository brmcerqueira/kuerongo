package com.brmcerqueira.kuerongo.config.wrappers

interface IJsonObjectNativeWrapper : IJsonNativeWrapper {
    fun <T : Any?> set(key: String, value: T)
}