@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("android-library-convention")
    kotlin("kapt")

    alias(libs.plugins.hilt)
}

android {
    namespace = "com.xavierlnc.network.retrofit"
}

dependencies {
    implementation(projects.network.realEstate)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.okhttp.mockwebserver)
}