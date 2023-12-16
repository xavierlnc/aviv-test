package utils

import getVersionsCatalog
import library
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import testImplementation
import testRuntimeOnly

internal fun Project.configureTest() {
    val versionCatalog = getVersionsCatalog()

    dependencies {
        testImplementation(platform(versionCatalog.library("junit-bom")))
        testImplementation("org.junit.jupiter:junit-jupiter-api")
        testImplementation("org.junit.jupiter:junit-jupiter-params")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

        testImplementation(versionCatalog.library("mockito-core"))
        testImplementation(versionCatalog.library("mockito-junit-jupiter"))
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
