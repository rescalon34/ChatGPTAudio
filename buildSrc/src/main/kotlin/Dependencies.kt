object ProjectConfiguration {
    const val applicationId = "com.escalondev.chatgptaudio"
    const val compileSdk = 33
    const val buildToolsVersion = "30.0.3"
    const val minSdk = 24
    const val targetSdk= 33
    const val versionCode = 1
    const val versionName = "1.0"
}

object CommonVersions {
    const val androidLibraryVersion = "7.4.0"
    const val kotlinVersion = "1.8.21"
    const val hiltVersion = "2.44"
    const val hiltNavigationComposeVersion = "1.0.0"
}

object GradlePlugings {
    // plugings
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val hiltAndroid = "com.google.dagger.hilt.android"
    const val kaptPlugin = "kapt"
}

object Deps {

    object Kotlin {
        private const val kotlinJdkVersion = "1.8.0"

        const val kotlinJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinJdkVersion"
        const val kotlinJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinJdkVersion"
    }

    object Core {
        // versions
        private const val coreKtxVersion = "1.10.1"
        private const val lifecycleKtxVersion = "2.6.1"
        private const val jUnitVersion = "4.13.2"
        private const val androidxJUnitVersion = "1.1.5"
        private const val espressoCoreVersion = "3.5.1"

        // dependencies
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
        const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleKtxVersion"
        const val espresso = "androidx.test.espresso:espresso-core:$espressoCoreVersion"
        const val jUnit = "junit:junit:$jUnitVersion"
        const val androidxJunit = "androidx.test.ext:junit:$androidxJUnitVersion"
    }

    object Compose {
        // versions
        private const val activityComposeVersion = "1.7.1"
        private const val composeVersion = "1.4.3"
        private const val composeViewModelVersion = "2.4.1"
        private const val material3Version = "1.2.0-alpha01"
        private const val navigationVersion = "2.5.3"
        private const val coilVersion = "2.2.0"

        // dependencies
        const val activity = "androidx.activity:activity-compose:$activityComposeVersion"
        const val ui = "androidx.compose.ui:ui:$composeVersion"
        const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        const val material3 = "androidx.compose.material3:material3:$material3Version"
        const val jUnit4 = "androidx.compose.ui:ui-test-junit4:$composeVersion"
        const val testManifest = "androidx.compose.ui:ui-test-manifest:$composeVersion"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:$composeViewModelVersion"
        const val composeNavigation = "androidx.navigation:navigation-compose:${navigationVersion}"
        const val coil = "io.coil-kt:coil-compose:${coilVersion}"
    }

    object Hilt {
        const val android = "com.google.dagger:hilt-android:${CommonVersions.hiltVersion}"
        const val androidCompiler = "com.google.dagger:hilt-android-compiler:${CommonVersions.hiltVersion}"
        const val hiltComposeNavigation = "androidx.hilt:hilt-navigation-compose:${CommonVersions.hiltNavigationComposeVersion}"
    }

    object Coroutines {
        const val coroutinesVersion = "1.3.9"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    }

    object Networking {
        const val retrofitVersion = "2.9.0"
        const val logginInterceptorVersion = "4.8.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
        const val logginInterceptor = "com.squareup.okhttp3:logging-interceptor:$logginInterceptorVersion"
    }
}
