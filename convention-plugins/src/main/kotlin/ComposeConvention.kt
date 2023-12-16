import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("unused")
class ComposeConvention : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.withPlugin("com.android.application") {
                configure<ApplicationExtension> {
                    configureCompose(this)
                }
            }

            pluginManager.withPlugin("com.android.library") {
                configure<LibraryExtension> {
                    configureCompose(this)
                }
            }
        }
    }
}
