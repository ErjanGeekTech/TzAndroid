plugins {
    id("com.android.application")
    kotlin("android")

    // Kapt
    kotlin("kapt")

    // Hilt
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = rootProject.extra["compileSdkVersion"].toString().toInt()

    defaultConfig {
        applicationId = "com.erjan.tzandroid"
        minSdk = rootProject.extra["minSdkVersion"].toString().toInt()
        targetSdk = rootProject.extra["targetSdkVersion"].toString().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        debug {
            applicationIdSuffix = ".debug"
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    // View Binding
    buildFeatures.viewBinding = true
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    // Core
    implementation("androidx.core:core-ktx:1.8.0")

    // AppCompat
    implementation("androidx.appcompat:appcompat:1.4.2")

    // Material Design
    implementation("com.google.android.material:material:1.6.1")

    // UI Components
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    //ViewBindingPropertyDelegate
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6")
    // Activity
    implementation("androidx.activity:activity-ktx:1.5.1")
    // Fragment
    implementation("androidx.fragment:fragment-ktx:1.5.1")


    // Navigation Component
    val navigation_version = "2.5.1"
    implementation("androidx.navigation:navigation-fragment-ktx:$navigation_version")
    implementation("androidx.navigation:navigation-ui-ktx:$navigation_version")

    // Lifecycle
    val lifecycle_version = "2.4.1"
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")

    // Hilt
    val hilt_version = "2.41"
    implementation("com.google.dagger:hilt-android:$hilt_version")
    kapt("com.google.dagger:hilt-compiler:$hilt_version")

    // Glide
    val glide_version = "4.13.2"
    implementation("com.github.bumptech.glide:glide:$glide_version")
    kapt("com.github.bumptech.glide:compiler:$glide_version")
}