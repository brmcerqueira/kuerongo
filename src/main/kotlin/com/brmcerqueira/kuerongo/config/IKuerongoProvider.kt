package com.brmcerqueira.kuerongo.config

interface IKuerongoProvider {
    fun createJsonObject(): IJsonObjectWrapper
    fun createJsonArray(): IJsonArrayWrapper
}