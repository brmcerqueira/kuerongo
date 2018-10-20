package com.brmcerqueira.kuerongo

interface IJsonArray {
    fun <T : Any?> addUsingMapper(value: T): IJsonArray
}