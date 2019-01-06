package com.brmcerqueira.kuerongo

class Json() : AbstractJson() {
    constructor(init: Json.() -> Unit) : this() {
        init()
    }

    infix fun <T> String.to(value: T) = this.set(value)

    infix fun String.to(init: Json.() -> Unit) = set(this, Json(), init)
}
