package com.brmcerqueira.kuerongo.config

interface IKuerongoProvider {
    fun createJsonObject(): IJsonObjectRaw
    fun createJsonArray(): IJsonArrayRaw
}