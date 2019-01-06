package com.brmcerqueira.kuerongo.config

interface IJsonArrayRaw : IJsonRaw {
    fun <T : Any?> add(value: T): IJsonArrayRaw
}