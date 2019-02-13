import com.jfrog.bintray.gradle.BintrayExtension

group = "com.brmcerqueira"
version = "1.0"

val kotlinVersion = "1.2.61"
val spekVersion = "2.0.0-rc.1"

plugins {
    `maven-publish`
    kotlin("jvm") version "1.2.61"
    id("com.jfrog.bintray") version "1.8.1"
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

val sourcesJar by tasks.registering(Jar::class) {
    classifier = "sources"
    from(sourceSets.main.get().allSource)
}

publishing {
    publications {
        create<MavenPublication>("bintray") {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}

bintray {
    user = findProperty("user").toString()
    key = findProperty("key").toString()
    publish = true
    setPublications("bintray")
    pkg(delegateClosureOf<BintrayExtension.PackageConfig> {
        repo = "com.brmcerqueira"
        name = "kuerongo"
        userOrg = "brmcerqueira"
        setLicenses("MIT")
        vcsUrl = "https://github.com/brmcerqueira/kuerongo.git"
    })
}

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines("spek2")
    }
    testLogging {
        events("passed", "skipped", "failed")
    }
}