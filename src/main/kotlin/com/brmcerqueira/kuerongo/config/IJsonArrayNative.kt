package com.brmcerqueira.kuerongo.config

interface IJsonArrayNative : IJsonNative {
    fun <T : Any?> add(value: T)
}