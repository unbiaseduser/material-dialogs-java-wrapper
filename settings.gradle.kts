pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    //repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "material-dialogs-java-wrapper"
include(":core")
include(":color")
include(":bottomsheets")
include(":datetime")
include(":files")
include(":input")
include(":lifecycle")
