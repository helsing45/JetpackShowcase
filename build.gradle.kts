// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        //noinspection UseTomlInstead
        classpath("com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:2.0.1")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.21"
}