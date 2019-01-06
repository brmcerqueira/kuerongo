package com.brmcerqueira.kuerongo.config

interface IKuerongoProvider {
    fun createJsonObject(): IJsonObject
    fun createJsonArray(): IJsonArray
}