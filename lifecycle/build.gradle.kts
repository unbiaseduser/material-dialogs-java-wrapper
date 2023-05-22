plugins {
    id("com.android.library")
    kotlin("android")
}

apply(from = "../publish.gradle")

ext.set("artifact_id", "lifecycle")

android {
    namespace = "com.sixtyninefourtwenty.materialdialogsjavawrapper.lifecycle"
    compileSdk = 33

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

    defaultConfig {
        minSdk = 21
    }

    buildFeatures {
        buildConfig = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    api(project(":core"))
    api("com.afollestad.material-dialogs:lifecycle:3.3.0")

    implementation("androidx.core:core-ktx:1.10.1")
}