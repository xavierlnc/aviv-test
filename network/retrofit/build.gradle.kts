plugins {
    id("android-library-convention")
}

android {
    defaultConfig {
        namespace = "com.xavierlnc.network.retrofit"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.network.realEstate)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.gson)

    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.okhttp.mockwebserver)
}