plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinParcelize()
    daggerHilt()
    kotlinKapt()
    ktlint()
}

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName(BuildType.DEBUG) {
            isTestCoverageEnabled = true
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFiles(project.file(
                "${project.rootProject.rootDir.absolutePath}/proguard-rules.pro"
            ))
        }
        getByName(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFiles(project.file(
                "${project.rootProject.rootDir.absolutePath}/proguard-rules.pro"
            ))
        }
    }

    compileOptions {
        sourceCompatibility = Versions.JAVA_VER
        targetCompatibility = Versions.JAVA_VER
    }

    kotlinOptions {
        jvmTarget = Versions.JAVA_VER_STRING
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(platform(project(":depconstraints")))
    implementation(project(mapOf("path" to ":domain")))
    kapt(platform(project(":depconstraints")))

    hiltComponent()
    retrofitComponent()
    okHttpComponent()

    implementation(Libs.TIMBER)
    implementation(Libs.GSON)

    implementation(Libs.HILT.HILT_COMMON)
    kapt(Libs.HILT.HILT_COMPILER)

    implementation(Libs.RETROFIT.RETROFIT)

    implementation(Libs.COROUTINE.COROUTINE_CORE)
    implementation(Libs.COROUTINE.COROUTINE_ANDROID)
}

ktlint {
    debug.set(true)
    verbose.set(true)
    android.set(true)
    outputToConsole.set(true)
    outputColorName.set("RED")
    reporters {
        reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
    }
    filter {
        exclude("**/generated/**")
        include("**/kotlin/**")
    }
}
