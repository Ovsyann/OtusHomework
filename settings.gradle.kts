rootProject.name = "JavaHomework"
include ("hw01-gradle")
include ("hw04-generics")
include ("hw06-annotations")
include ("hw08-gc")
include("hw08-gc:demo")
include("hw08-gc:homework")
include ("hw10-byteCodes")



pluginManagement {
    val jgitver: String by settings
    val dependencyManagement: String by settings
    val springframeworkBoot: String by settings
    val johnrengelmanShadow: String by settings
    val jib: String by settings
    val protobufVer: String by settings

    plugins {
        id("fr.brouillard.oss.gradle.jgitver") version jgitver
        id("io.spring.dependency-management") version dependencyManagement
        id("org.springframework.boot") version springframeworkBoot
        id("com.github.johnrengelman.shadow") version johnrengelmanShadow
        id("com.google.cloud.tools.jib") version jib
        id("com.google.protobuf") version protobufVer
    }
}