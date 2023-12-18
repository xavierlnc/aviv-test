@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("android-library-convention")
    id("compose-convention")
    kotlin("kapt")

    alias(libs.plugins.hilt)
}

android {
    namespace = "com.xavierlnc.aviv.features.realEstateList"
}

dependencies {
    implementation(projects.aviv.features.shared.formatter)
    implementation(projects.aviv.features.shared.common)
    implementation(projects.network.realEstate)
    implementation(projects.network.retrofit)
    implementation(projects.designSystem)

    implementation(libs.androidx.core)
    implementation(libs.activity.compose)
    implementation(libs.kotlin.immutablelist)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    testImplementation(libs.turbine)
    testImplementation(libs.kotlin.coroutines.test)
}