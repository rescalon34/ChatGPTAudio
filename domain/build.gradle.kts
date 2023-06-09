plugins {
    id(GradlePlugings.androidLibrary)
    id(GradlePlugings.kotlinAndroid)
    kotlin(GradlePlugings.kaptPlugin)
    id(GradlePlugings.hiltAndroid)
}

@Suppress("UnstableApiUsage")
android {
    namespace = "${ProjectConfiguration.applicationId}.${project.name}"
    println("namespace: ${namespace.orEmpty()}")
    compileSdk = ProjectConfiguration.compileSdk

    defaultConfig {
        minSdk = ProjectConfiguration.minSdk
        targetSdk = ProjectConfiguration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    // hilt
    implementation(Deps.Hilt.android)
    kapt(Deps.Hilt.androidCompiler)

    testImplementation(Deps.Core.jUnit)
    androidTestImplementation(Deps.Core.espresso)
    androidTestImplementation(Deps.Core.androidxJunit)
}
