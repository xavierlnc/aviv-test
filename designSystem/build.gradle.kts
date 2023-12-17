plugins {
    id("android-library-convention")
    id("compose-convention")
}

android {
    namespace = "com.xavierlnc.designSystem"
}

dependencies {
    implementation(libs.androidx.core)

    implementation(libs.glide.compose)
}
