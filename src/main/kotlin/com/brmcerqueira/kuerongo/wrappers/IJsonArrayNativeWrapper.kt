package com.brmcerqueira.kuerongo.wrappers

interface IJsonArrayNativeWrapper : IJsonNativeWrapper {
    fun <T : Any?> add(value: T)
}