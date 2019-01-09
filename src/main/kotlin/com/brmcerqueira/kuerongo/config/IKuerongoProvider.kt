package com.brmcerqueira.kuerongo.config

import com.brmcerqueira.kuerongo.wrappers.IJsonArrayNativeWrapper
import com.brmcerqueira.kuerongo.wrappers.IJsonObjectNativeWrapper

interface IKuerongoProvider {
    fun createJsonObject(): IJsonObjectNativeWrapper
    fun createJsonArray(): IJsonArrayNativeWrapper
}