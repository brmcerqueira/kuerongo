package com.brmcerqueira.kuerongo

class PushField : AbstractJson() {
    fun each(vararg values: Any) {
        wrapper.set("\$each", JsonArray().put(*values))
    }

    fun sort(init: Sort.() -> Unit) {
        wrapper.set("\$sort", Sort(init))
    }

    fun position(value: Int) {
        wrapper.set("\$position", value)
    }

    fun slice(value: Int) {
        wrapper.set("\$slice", value)
    }
}