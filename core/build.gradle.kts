import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.library")
    id("kotlin-android")
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(kotlin(Deps.Kotlin.stdlib, KotlinCompilerVersion.VERSION))
    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.AndroidX.palette)
    implementation(Deps.AndroidX.ktx)
}

project.apply {
    extensions.add("artifact", ProjectSettings.Core.artifact)
    extensions.add("libraryName", ProjectSettings.Core.artifact)
    extensions.add("libraryDescription", ProjectSettings.Core.description)
}

apply("../publish.script.gradle")
