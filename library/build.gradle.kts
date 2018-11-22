import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.github.dcendents.android-maven")
}

group = "com.github.thefuntasty"

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

    // Kotlin
    implementation(kotlin(Deps.Kotlin.stdlib, KotlinCompilerVersion.VERSION))
    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.AndroidX.palette)
    implementation(Deps.AndroidX.ktx)
}

tasks {
    val sourcesJar by creating(type = Jar::class) {
        from("android.sourceSets.main.java.srcDirs")
        classifier = "sources"
    }

    artifacts {
        add("archives", sourcesJar)
    }
}
