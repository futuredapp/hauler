plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
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
    implementation(project(":library"))

    // Kotlin
    implementation(kotlin(Deps.Kotlin.stdlib, Versions.kotlin))
    implementation(Deps.AndroidX.appcompat)
}

tasks {
    val sourcesJar by creating(type = Jar::class) {
        from(android.sourceSets.getByName("main").java.srcDirs)
        classifier = "sources"
    }

    artifacts {
        add("archives", sourcesJar)
    }
}
