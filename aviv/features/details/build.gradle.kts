plugins {
    id("android-library-convention")
    id("compose-convention")
}

android {
    namespace = "com.xavierlnc.aviv.features.details"
}

dependencies {
    implementation(libs.androidx.core)
}