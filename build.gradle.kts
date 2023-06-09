// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(GradlePlugings.androidApplication) version CommonVersions.androidLibraryVersion apply false
    id(GradlePlugings.androidLibrary) version CommonVersions.androidLibraryVersion apply false
    id(GradlePlugings.kotlinAndroid) version CommonVersions.kotlinVersion apply false
    id(GradlePlugings.hiltAndroid) version CommonVersions.hiltVersion apply false
}
