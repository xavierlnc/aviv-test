import org.gradle.kotlin.dsl.support.delegates.DependencyHandlerDelegate

internal fun DependencyHandlerDelegate.implementation(dependency: Any) {
    add("implementation", dependency)
}

internal fun DependencyHandlerDelegate.testImplementation(dependency: Any) {
    add("testImplementation", dependency)
}

internal fun DependencyHandlerDelegate.debugImplementation(dependency: Any) {
    add("debugImplementation", dependency)
}

internal fun DependencyHandlerDelegate.testRuntimeOnly(dependency: Any) {
    add("testRuntimeOnly", dependency)
}

internal fun DependencyHandlerDelegate.coreLibraryDesugaring(dependency: Any) {
    add("coreLibraryDesugaring", dependency)
}
