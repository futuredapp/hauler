import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Deps.gradlePlugin)
        classpath(kotlin(Deps.Kotlin.gradlePlugin, Versions.kotlin))
        classpath(Deps.Plugins.bintray)
        classpath(Deps.Plugins.dokka)
    }

    extra.apply {
        set("bintrayRepo", ProjectSettings.Publish.bintrayRepo)
        set("publishedGroupId", ProjectSettings.group)
        set("siteUrl", ProjectSettings.Publish.siteUrl)
        set("gitUrl", ProjectSettings.Publish.gitUrl)
        set("developerId", ProjectSettings.Publish.developerId)
        set("developerName", ProjectSettings.Publish.developerName)
        set("developerEmail", ProjectSettings.Publish.developerEmail)
        set("licenseName", ProjectSettings.Publish.licenseName)
        set("licenseUrl", ProjectSettings.Publish.licenseUrl)
        set("allLicenses", ProjectSettings.Publish.allLicenses)
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
}

tasks {
    register<com.thefuntasty.hauler.DependencyUpdates>("dependencyUpdates")
}

detekt {
    version = Versions.detekt
    input = files("sample/src/main/kotlin", "library/src/main/kotlin")
    config = files("detekt.yml")
    autoCorrect = false
}
