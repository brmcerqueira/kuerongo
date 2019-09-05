package com.brmcerqueira.kuerongo

class Update() : AbstractJson() {
    constructor(init: Update.() -> Unit) : this() {
        init()
    }

    operator fun <T> String.timesAssign(value: T) = this.set(value)

    fun inc(init: Json.() -> Unit) {
        wrapper.set("\$inc", Json(init))
    }

    fun min(init: Json.() -> Unit) {
        wrapper.set("\$min", Json(init))
    }

    fun max(init: Json.() -> Unit) {
        wrapper.set("\$max", Json(init))
    }

    fun mul(init: Json.() -> Unit) {
        wrapper.set("\$mul", Json(init))
    }

    fun rename(init: Json.() -> Unit) {
        wrapper.set("\$rename", Json(init))
    }

    fun set(init: Json.() -> Unit) {
        wrapper.set("\$set", Json(init))
    }

    fun setOnInsert(init: Json.() -> Unit) {
        wrapper.set("\$setOnInsert", Json(init))
    }

    fun unset(init: Unset.() -> Unit) {
        wrapper.set("\$unset", Unset(init))
    }

    fun currentDate(init: CurrentDate.() -> Unit) {
        wrapper.set("\$currentDate", CurrentDate(init))
    }
}