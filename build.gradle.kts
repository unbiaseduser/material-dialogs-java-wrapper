// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.1" apply false
    kotlin("android") version "1.8.20" apply false
    id("com.android.library") version "8.0.1" apply false
    id("com.diffplug.spotless") version "6.18.0"
}

subprojects {
    apply(plugin = "com.diffplug.spotless")

    configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            targetExclude("$buildDir/**/*.kt")
            licenseHeaderFile("../spotless.license.kt")
            trimTrailingWhitespace()
            endWithNewline()
        }
    }
}
