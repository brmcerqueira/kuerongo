package com.brmcerqueira.kuerongo.config.wrappers

interface IJsonArrayNativeWrapper : IJsonNativeWrapper {
    fun <T : Any?> add(value: T)
}