import com.jfrog.bintray.gradle.BintrayExtension

group = "com.brmcerqueira"
version = "1.0.18"
val kotlinVersion = "1.2.61"

plugins {
    `maven-publish`
    kotlin("jvm") version "1.2.61"
    id("com.jfrog.bintray") version "1.8.1"
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
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
        includeEngines("junit-jupiter")
    }
    testLogging {
        events("passed", "skipped", "failed")
    }
}