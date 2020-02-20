object ProjectSettings {
    const val applicationId = "com.thefuntasty.hauler"
    const val targetSdk = 29
    const val minSdk = 21
    const val group = "com.thefuntasty.hauler"
    val version = System.getenv("BITRISE_GIT_TAG")?:"0.0.1-TEST"

    object Core {
        const val artifact = "core"
        const val description = "Library containing custom layout which enables to easily create swipe to dismiss Activity"
    }

    object Databinding {
        const val artifact = "databinding"
        const val description = "Databinding extensions for core library"
    }


    object Publish {
        const val bintrayRepo = "hauler"
        const val siteUrl = "https://github.com/futuredapp/hauler"
        const val gitUrl = "https://github.com/futuredapp/hauler.git"
        const val developerId = "TheFuntasty"
        const val developerName = "TheFuntasty"
        const val developerEmail = "ops@thefuntasty.com"
        const val licenseName = "MIT Licence"
        const val licenseUrl = "https://github.com/futuredapp/hauler/blob/master/LICENSE"
        val allLicenses = listOf("MIT")
    }
}
