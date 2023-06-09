plugins {
    id(GradlePlugings.androidApplication)
    id(GradlePlugings.kotlinAndroid)
    kotlin(GradlePlugings.kaptPlugin)
    id(GradlePlugings.hiltAndroid)
}

@Suppress("UnstableApiUsage")
android {
    namespace = ProjectConfiguration.applicationId
    compileSdk = ProjectConfiguration.compileSdk

    defaultConfig {
        applicationId = ProjectConfiguration.applicationId
        minSdk = ProjectConfiguration.minSdk
        targetSdk = ProjectConfiguration.targetSdk
        versionCode = ProjectConfiguration.versionCode
        versionName = ProjectConfiguration.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    // modules
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Deps.Core.lifecycleKtx)
    implementation(Deps.Compose.activity)
    implementation(Deps.Compose.ui)
    implementation(Deps.Compose.material3)
    implementation(Deps.Compose.testManifest)
    implementation(Deps.Compose.composeNavigation)
    implementation(Deps.Compose.uiToolingPreview)
    implementation(Deps.Compose.viewModel)

    // hilt
    implementation(Deps.Hilt.android)
    implementation(Deps.Hilt.hiltComposeNavigation)
    kapt(Deps.Hilt.androidCompiler)

    debugImplementation(Deps.Compose.uiTooling)

    // testing
    testImplementation(Deps.Core.jUnit)
    androidTestImplementation(Deps.Compose.jUnit4)
    androidTestImplementation(Deps.Core.espresso)
    androidTestImplementation(Deps.Core.androidxJunit)

    // due to "Duplicate class kotlin.collections.jdk8.CollectionsJDK8Kt" error
    constraints {
        implementation(Deps.Kotlin.kotlinJdk8) {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }
}
