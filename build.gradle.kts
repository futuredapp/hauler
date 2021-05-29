import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Deps.gradlePlugin)
        classpath(kotlin(Deps.Kotlin.gradlePlugin, Versions.kotlin))
        classpath(Deps.Plugins.mavenPublish)
        classpath(Deps.Plugins.dokka)
    }
}

plugins {
    idea
    id(Deps.Plugins.detekt) version Versions.detekt
    id(Deps.Plugins.ktlint) version Versions.ktlint
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = Deps.Plugins.ktlint)

    ktlint {
        version.set(Versions.ktlintExtension)
        ignoreFailures.set(true)
        android.set(true)
        outputToConsole.set(true)
        reporters {
            reporter(ReporterType.PLAIN)
            reporter(ReporterType.CHECKSTYLE)
        }
    }

    plugins.whenPluginAdded {
        if (this is SigningPlugin) {
            extensions.findByType<SigningExtension>()?.apply {
                val hasKey = project.hasProperty("SIGNING_PRIVATE_KEY")
                val hasPassword = project.hasProperty("SIGNING_PASSWORD")

                if (hasKey && hasPassword) {
                    useInMemoryPgpKeys(
                        project.properties["SIGNING_PRIVATE_KEY"].toString(),
                        project.properties["SIGNING_PASSWORD"].toString()
                    )
                }
            }
        }
    }
}

detekt {
    autoCorrect = false
    version = Versions.detekt
    input = files("sample/src/main/kotlin", "library/src/main/kotlin")
    config = files("detekt.yml")
}
