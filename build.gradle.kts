group = "com.brmcerqueira"

version = "1.0"

plugins {
    application
    kotlin("jvm") version "1.2.61"
}

dependencies {
    compile(kotlin("stdlib"))
}

repositories {
    jcenter()
}