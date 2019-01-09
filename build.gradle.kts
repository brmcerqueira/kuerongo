group = "com.brmcerqueira"

version = "1.0"

val kotlinVersion = "1.2.61"
val spekVersion = "2.0.0-rc.1"

plugins {
    application
    kotlin("jvm") version "1.2.61"
}

dependencies {
    compile(kotlin("stdlib"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")  {
        exclude("org.jetbrains.kotlin")
    }

    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion") {
        exclude("org.junit.platform")
        exclude("org.jetbrains.kotlin")
    }

    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
}

repositories {
    jcenter()
    mavenCentral()
}

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines("spek2")
    }
    testLogging {
        events("passed", "skipped", "failed")
    }
}