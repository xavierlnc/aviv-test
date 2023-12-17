pluginManagement {
    includeBuild("convention-plugins")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "aviv-test"

include(
    ":designSystem"
)

apply(from = "aviv/settings.gradle.kts")
apply(from = "network/settings.gradle.kts")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
