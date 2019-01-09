package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.wrappers.IJsonWrapper

abstract class AbstractRoot<T : IJsonWrapper>(protected val wrapper: T) : IRootJson {
    @Suppress("UNCHECKED_CAST")
    override fun <TRaw> raw(): TRaw = wrapper.nativeWrapper.raw as TRaw
}