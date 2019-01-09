package com.brmcerqueira.kuerongo.config

interface IKuerongoProvider {
    fun createJsonObject(): IJsonObjectNative
    fun createJsonArray(): IJsonArrayNative
}