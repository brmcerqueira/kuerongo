package com.brmcerqueira.kuerongo.wrappers

interface IJsonObjectNativeWrapper : IJsonNativeWrapper {
    fun <T : Any?> set(key: String, value: T)
}