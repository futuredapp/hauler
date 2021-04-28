object ProjectSettings {
    const val applicationId = "app.futured.hauler"
    const val targetSdk = 29
    const val minSdk = 21
    const val group = "app.futured.hauler"

    /**
     * 0.0.1-SNAPSHOT used only for local builds.
     * Snapshots will use version name from VERSION_NAME property of project gradle.properties file.
     * Releases will use version name from Github release. VERSION_NAME is overridden in release workflow file.
     */
    val version = System.getenv("VERSION_NAME") ?: "0.0.1-SNAPSHOT"
}
