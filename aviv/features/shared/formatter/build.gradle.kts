@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("android-library-convention")
    kotlin("kapt")

    alias(libs.plugins.hilt)
}

android {
    namespace = "com.xavierlnc.aviv.features.shared.formatter"
}

dependencies {
    implementation(libs.androidx.core)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
}