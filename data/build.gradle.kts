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

        buildConfigField("String", "BASE_URL", (project.properties["baseUrl"] ?: "").toString())
        buildConfigField("String", "API_KEY", (project.properties["apiKey"] ?: "").toString())
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

    // modules
    implementation(project(":domain"))

    // hilt
    implementation(Deps.Hilt.android)
    kapt(Deps.Hilt.androidCompiler)

    // core
    api(Deps.Core.coreKtx)

    // coroutines
    api(Deps.Coroutines.coroutines)

    // networking
    implementation(Deps.Networking.retrofit)
    implementation(Deps.Networking.gsonConverter)
    implementation(Deps.Networking.logginInterceptor)

    //testing
    testImplementation(Deps.Core.jUnit)
    androidTestImplementation(Deps.Core.espresso)
    androidTestImplementation(Deps.Core.androidxJunit)
}
