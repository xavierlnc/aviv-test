import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependencyBundle
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.provider.Provider

internal fun Project.getVersionsCatalog(): VersionCatalog {
    return try {
        project.extensions.getByType(VersionCatalogsExtension::class.java).named("libs")
    } catch (_: Exception) {
        error("Version Catalog not found")
    }
}

internal fun VersionCatalog.library(name: String): Provider<MinimalExternalModuleDependency> =
    findLibrary(name)
        .orElseGet { error("Library $name not found in version catalog") }

internal fun VersionCatalog.bundle(name: String): Provider<ExternalModuleDependencyBundle> =
    findBundle(name)
        .orElseGet { error("Bundle $name not found in version catalog") }

internal fun VersionCatalog.version(name: String): String =
    findVersion(name)
        .orElseGet { error("Version $name not found in version catalog") }
        .requiredVersion
