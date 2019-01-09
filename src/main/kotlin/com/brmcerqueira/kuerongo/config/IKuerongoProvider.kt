package com.brmcerqueira.kuerongo.config

import com.brmcerqueira.kuerongo.config.wrappers.IJsonArrayNativeWrapper
import com.brmcerqueira.kuerongo.config.wrappers.IJsonObjectNativeWrapper

interface IKuerongoProvider {
    fun createJsonObject(): IJsonObjectNativeWrapper
    fun createJsonArray(): IJsonArrayNativeWrapper
}