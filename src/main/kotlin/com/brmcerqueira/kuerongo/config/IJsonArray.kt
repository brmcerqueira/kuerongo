package com.brmcerqueira.kuerongo.config

interface IJsonArray {
    val isEmpty: Boolean
    fun <T : Any?> addUsingMapper(value: T): IJsonArray
}