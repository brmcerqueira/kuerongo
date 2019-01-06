package com.brmcerqueira.kuerongo.config

import java.lang.UnsupportedOperationException

class KuerongoConfig {
    companion object {
        private var instance: IKuerongoProvider? = null
        var kuerongoProvider: IKuerongoProvider
            get() = if (instance == null) {
                instance = DefaultKuerongoProvider()
                instance!!
            } else instance!!
            set(value) {
                if (instance == null) {
                    instance = value
                }
                else throw UnsupportedOperationException()
            }
    }
}