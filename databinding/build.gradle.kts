import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

group = ProjectSettings.group
version = ProjectSettings.version

android {
    compileSdkVersion(ProjectSettings.targetSdk)

    defaultConfig {
        minSdkVersion(ProjectSettings.minSdk)
        targetSdkVersion(ProjectSettings.targetSdk)
    }

    sourceSets {
        getByName("main").java.srcDir("src/main/kotlin")
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(project(":core"))

    implementation(kotlin(Deps.Kotlin.stdlib, KotlinCompilerVersion.VERSION))
    implementation(Deps.AndroidX.appcompat)
}

project.apply {
    extensions.add("artifact", ProjectSettings.Databinding.artifact)
    extensions.add("libraryName", ProjectSettings.Databinding.artifact)
    extensions.add("libraryDescription", ProjectSettings.Databinding.description)
}

apply("../publish.script.gradle")

