plugins {
    id("com.android.library")
    kotlin("android")
}

apply(from = "../publish.gradle")

ext.set("artifact_id", "input")

android {
    namespace = "com.sixtyninefourtwenty.materialdialogsjavawrapper.input"
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    api(project(":core"))
    api("com.afollestad.material-dialogs:input:3.3.0")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs_minimal:2.0.3")

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("com.google.android.material:material:1.9.0")
}