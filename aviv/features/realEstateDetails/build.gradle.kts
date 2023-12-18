@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("android-library-convention")
    id("compose-convention")
    kotlin("kapt")

    alias(libs.plugins.hilt)
}

android {
    namespace = "com.xavierlnc.aviv.features.realEstateDetails"
}

dependencies {
    implementation(projects.aviv.features.shared.formatter)
    implementation(projects.aviv.features.shared.common)
    implementation(projects.network.realEstate)
    implementation(projects.network.retrofit)
    implementation(projects.designSystem)

    implementation(libs.androidx.core)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
}