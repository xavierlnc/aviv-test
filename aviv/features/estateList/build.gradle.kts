@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("android-library-convention")
    id("compose-convention")
    kotlin("kapt")

    alias(libs.plugins.hilt)
}

android {
    namespace = "com.xavierlnc.aviv.features.estateList"
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.activity.compose)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
}