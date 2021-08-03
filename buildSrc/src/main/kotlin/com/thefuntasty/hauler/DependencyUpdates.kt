package com.thefuntasty.hauler
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

abstract class DependencyUpdates : DependencyUpdatesTask() {

    init {
        group = "hauler"

        this.resolutionStrategy {
            componentSelection {
                all {
                    val rejected = listOf("alpha", "beta", "rc", "cr", "m", "preview", "testing")
                        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-]*") }
                        .any { it.matches(candidate.version) }
                    if (rejected) {
                        reject("Release candidate")
                    }
                }
            }
        }
    }
}
