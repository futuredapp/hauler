object Deps {
    const val gradlePlugin = "com.android.tools.build:gradle:${Versions.gradle}"

    object Plugins {
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val mavenPublish = "com.vanniktech:gradle-maven-publish-plugin:${Versions.mavenPublish}"
        const val dokka = "org.jetbrains.dokka:dokka-gradle-plugin:${Versions.dokka}"
    }

    object Kotlin {
        const val gradlePlugin = "gradle-plugin"
        const val stdlib = "stdlib-jdk7"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:${Versions.androidx}"
        const val palette = "androidx.palette:palette:${Versions.palette}"
        const val ktx = "androidx.core:core-ktx:${Versions.androidxKtx}"
    }
}
