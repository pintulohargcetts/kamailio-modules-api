apply(from = "version.gradle.kts")

val profile = if (project.hasProperty("profile")) project.property("profile").toString() else "default"
val artifactName = "${rootProject.name}-$profile-${rootProject.version}.jar"
plugins {
    id("org.springframework.boot") version "3.2.7"
    id("io.spring.dependency-management") version "1.1.5"
    kotlin("plugin.jpa") version "1.9.24"
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
}

group = "com.plohar.kamailio"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}
sourceSets {
    main {
        resources {
            srcDirs(listOf("src/main/resources", "src/main/resources-$profile"))
        }
    }
    test {
        resources {
            srcDirs(listOf("src/test/resources", "src/test/resources"))
        }
    }
}
repositories {
    mavenCentral()
}
springBoot {
    buildInfo()
}
dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.5.0")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.modelmapper:modelmapper:2.3.8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.r2dbc:r2dbc-spi:0.9.0.RELEASE")
    implementation("dev.miku:r2dbc-mysql:0.8.2.RELEASE")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.github.microutils:kotlin-logging:3.0.5")
    implementation("io.kotest:kotest-extensions-spring:4.4.3")




    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")

    }
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("io.kotest:kotest-assertions-core:5.5.5")
    testImplementation("io.kotest:kotest-runner-junit5:5.5.5")
    testImplementation("io.kotest:kotest-property:5.5.5")
    testImplementation("io.mockk:mockk:1.12.0")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
