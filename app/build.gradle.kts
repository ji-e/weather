plugins {
    androidApp()
    kotlinAndroid()
    kotlinKapt()
    kotlinParcelize()
    daggerHilt()
    ktlint()
}

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.jieun.weather"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = 1
        versionName = "${Versions.major}.${Versions.minor}.${Versions.patch}"
        setProperty("archivesBaseName", "weather_$versionName.$versionCode")
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
    implementation(project(mapOf("path" to ":data")))
    kapt(platform(project(":depconstraints")))
    androidTestImplementation(project(mapOf("path" to ":app")))

    implementation(Libs.KTX.CORE_KTX)
    implementation(Libs.KTX.ACTIVITY_KTX)

    implementation(Libs.Androidx.APPCOMPAT)
    implementation(Libs.Androidx.MATERIAL)
    implementation(Libs.Androidx.CONSTRAINT_LAYOUT)
    testImplementation(Libs.Test.JUNIT4)
    androidTestImplementation(Libs.AndroidTest.EXT_JUNIT)
    androidTestImplementation(Libs.AndroidTest.ESPRESSO_CORE)

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

    implementation(Libs.LIFECYCLE.LIFECYCLE_VIEWMODEL)
    implementation(Libs.LIFECYCLE.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Libs.LIFECYCLE.LIFECYCLE_LIVEDATA)
    implementation(Libs.LIFECYCLE.LIFECYCLE_LIVEDATA_KTX)
    implementation(Libs.LIFECYCLE.LIFECYCLE_EXTENSION)
}

kapt {
    useBuildCache = true
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
