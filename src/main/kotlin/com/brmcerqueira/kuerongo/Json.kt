package com.brmcerqueira.kuerongo

class Json() : AbstractJson() {

    constructor(init: Json.() -> Unit) : this() {
        init()
    }

    infix fun String.to(init: Json.() -> Unit) = to(this, Json(), init)
}
