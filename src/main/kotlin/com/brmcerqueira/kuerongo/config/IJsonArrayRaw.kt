package com.brmcerqueira.kuerongo.config

interface IJsonArrayRaw {
    val isEmpty: Boolean
    fun <T : Any?> add(value: T): IJsonArrayRaw
}