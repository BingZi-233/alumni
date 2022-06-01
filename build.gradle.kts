val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
val mybatisVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "online.bingzi"
version = "1.0.3"
application {
    mainClass.set("online.bingzi.ApplicationKt")
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.alibaba.fastjson2:fastjson2:2.0.3")
    implementation("mysql:mysql-connector-java:8.0.29")
    implementation("org.mybatis:mybatis:$mybatisVersion")
    implementation("io.ktor:ktor-server-thymeleaf:$ktorVersion")
    implementation("io.ktor:ktor-server-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-auth-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:$ktorVersion")
    implementation("io.ktor:ktor-server-netty-jvm:$ktorVersion")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}

tasks {
    shadowJar {
        manifest {
            attributes(Pair("Main-Class", "io.ktor.server.netty.EngineMain"))
        }
    }
}