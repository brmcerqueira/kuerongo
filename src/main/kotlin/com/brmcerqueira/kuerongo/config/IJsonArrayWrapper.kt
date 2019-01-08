package com.brmcerqueira.kuerongo.config

interface IJsonArrayWrapper : IJsonWrapper {
    fun <T : Any?> add(value: T): IJsonArrayWrapper
}