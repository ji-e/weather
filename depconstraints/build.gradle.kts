plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    id("maven-publish")
}
dependencies {
    constraints {
        implementation("${Libs.KTX.CORE_KTX}:${Versions.CORE_KTX}")
        implementation("${Libs.KTX.ACTIVITY_KTX}:${Versions.ACTIVITY_KTX}")
        implementation("${Libs.Androidx.APPCOMPAT}:${Versions.APPCOMPAT}")
        implementation("${Libs.Androidx.MATERIAL}:${Versions.MATERIAL}")
        implementation("${Libs.Androidx.CONSTRAINT_LAYOUT}:${Versions.CONSTRAINT_LAYOUT}")
        implementation("${Libs.Test.JUNIT4}:${Versions.JUNIT4}")
        implementation("${Libs.AndroidTest.EXT_JUNIT}:${Versions.EXT_JUNIT}")
        implementation("${Libs.AndroidTest.ESPRESSO_CORE}:${Versions.ESPRESSO_CORE}")

        implementation("${Libs.TIMBER}:${Versions.TIMBER}")

        implementation("${Libs.GSON}:${Versions.GSON}")

        implementation("${Libs.HILT.DAGGER_HILT_ANDROID}:${Versions.DAGGER_HILT}")
        implementation("${Libs.HILT.DAGGER_HILT_COMPILER}:${Versions.DAGGER_HILT}")
        implementation("${Libs.HILT.DAGGER_HILT_TESTING}:${Versions.DAGGER_HILT}")
        implementation("${Libs.HILT.HILT_COMMON}:${Versions.HILT}")
        implementation("${Libs.HILT.HILT_COMPILER}:${Versions.HILT}")

        implementation("${Libs.RETROFIT.RETROFIT}:${Versions.RETROFIT}")
        implementation("${Libs.RETROFIT.RETROFIT_ADAPTER}:${Versions.RETROFIT}")
        implementation("${Libs.RETROFIT.RETROFIT_CONVERTER}:${Versions.RETROFIT}")

        implementation("${Libs.OKHTTP.OKHTTP3}:${Versions.OKHTTP}")
        implementation("${Libs.OKHTTP.OKHTTP3_INTERCEPTOR}:${Versions.OKHTTP}")

        implementation("${Libs.COROUTINE.COROUTINE_CORE}:${Versions.COROUTINE}")
        implementation("${Libs.COROUTINE.COROUTINE_ANDROID}:${Versions.COROUTINE}")

        implementation("${Libs.LIFECYCLE.LIFECYCLE_VIEWMODEL}:${Versions.LIFECYCLE}")
        implementation("${Libs.LIFECYCLE.LIFECYCLE_VIEWMODEL_KTX}:${Versions.LIFECYCLE}")
        implementation("${Libs.LIFECYCLE.LIFECYCLE_LIVEDATA}:${Versions.LIFECYCLE}")
        implementation("${Libs.LIFECYCLE.LIFECYCLE_LIVEDATA_KTX}:${Versions.LIFECYCLE}")
        implementation("${Libs.LIFECYCLE.LIFECYCLE_EXTENSION}:${Versions.LIFECYCLE_EXTENSION}")
    }
}

java {
    sourceCompatibility = Versions.JAVA_VER
    targetCompatibility = Versions.JAVA_VER
}