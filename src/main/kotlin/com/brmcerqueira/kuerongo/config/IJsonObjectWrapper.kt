package com.brmcerqueira.kuerongo.config

interface IJsonObjectWrapper : IJsonWrapper {
    fun <T : Any?> set(key: String, value: T): IJsonObjectWrapper
}