import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    application
    kotlin("jvm") version "1.5.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"

}

application.mainClassName = "club.minnced.bot.Main"

group = "club.minnced"
version = "1.0-SNAPSHOT"

repositories {
    maven(uri("https://jitpack.io"))
    jcenter()
    mavenCentral()
}
val JDA_VERSION = "4.2.1"

dependencies {
    implementation("club.minnced:jda-reactor:1.0.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("com.github.DV8FromTheWorld:JDA:v4.2.1") {
        exclude(module = "opus-java")
    }
//    implementation("zemberek-nlp:zemberek-normalization:0.17.1")


    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<ShadowJar> {
    minimize()
}
