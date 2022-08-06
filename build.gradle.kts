// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.0" apply false
    id("com.android.library") version "7.2.0" apply false
    kotlin("android") version "1.6.21" apply false

    // Hilt
    id("com.google.dagger.hilt.android") version "2.41" apply false
}

ext {
    extra["compileSdkVersion"] = 32
    extra["minSdkVersion"] = 23
    extra["targetSdkVersion"] = 32
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}