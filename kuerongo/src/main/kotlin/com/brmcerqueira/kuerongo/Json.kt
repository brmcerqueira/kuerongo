package com.brmcerqueira.kuerongo

class Json() : AbstractJson() {
    constructor(init: Json.() -> Unit) : this() {
        init()
    }

    operator fun <T> String.timesAssign(value: T) = this.set(value)

    operator fun String.timesAssign(init: Json.() -> Unit) = set(this, Json(), init)
}
