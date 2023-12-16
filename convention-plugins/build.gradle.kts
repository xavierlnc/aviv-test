@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compileOnly(libs.gradle.android)
    compileOnly(libs.gradle.kotlin)
}

gradlePlugin {
    plugins {
        create("ApplicationConvention") {
            id = "application-convention"
            implementationClass = "ApplicationConvention"
        }
        create("AndroidLibraryConvention") {
            id = "android-library-convention"
            implementationClass = "AndroidLibraryConvention"
        }
        create("KotlinLibraryConvention") {
            id = "kotlin-library-convention"
            implementationClass = "KotlinLibraryConvention"
        }
        create("ComposeConvention") {
            id = "compose-convention"
            implementationClass = "ComposeConvention"
        }
    }
}