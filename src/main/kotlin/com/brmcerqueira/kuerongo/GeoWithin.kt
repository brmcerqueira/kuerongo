package com.brmcerqueira.kuerongo

class GeoWithin : Ex() {
    fun centerSphere(x: Double, y: Double, radius: Double) {
        wrapper.set("\$centerSphere", JsonArray().put(JsonArray().put(x, y), radius))
    }
}