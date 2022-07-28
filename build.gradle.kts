plugins {
    androidApp() version Versions.ANDROID apply false
    androidLibrary() version Versions.ANDROID apply false
    jetbrains() version Versions.JETBRAINS apply false
    jetbrainsJvm() version Versions.JETBRAINS apply false
}

buildscript {
//    addScriptRepository()

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${Versions.KOTLIN}")
        classpath("org.jlleitschuh.gradle:ktlint-gradle:${Versions.KTLINT}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER_HILT}")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}