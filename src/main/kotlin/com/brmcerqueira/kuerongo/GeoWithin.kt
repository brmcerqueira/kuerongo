package com.brmcerqueira.kuerongo

class GeoWithin : Expression() {
    fun centerSphere(x: Double, y: Double, radius: Double) {
        wrapper.set("\$centerSphere", JsonArray().put(JsonArray().put(x, y), radius))
    }
}