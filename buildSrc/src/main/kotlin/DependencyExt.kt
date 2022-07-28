import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope


fun DependencyHandlerScope.hiltComponent() {
    implementation(Libs.HILT.DAGGER_HILT_ANDROID)
    kapt(Libs.HILT.DAGGER_HILT_COMPILER)
    testImplementation(Libs.HILT.DAGGER_HILT_TESTING)
}

fun DependencyHandlerScope.retrofitComponent() {
    implementation(Libs.RETROFIT.RETROFIT)
    implementation(Libs.RETROFIT.RETROFIT_ADAPTER)
    implementation(Libs.RETROFIT.RETROFIT_CONVERTER)
}

fun DependencyHandlerScope.okHttpComponent() {
    implementation(Libs.OKHTTP.OKHTTP3)
    implementation(Libs.OKHTTP.OKHTTP3_INTERCEPTOR)
}


private fun DependencyHandler.implementation(depName: String) =
    add("implementation", depName)

private fun DependencyHandler.kapt(depName: String) =
    add("kapt", depName)

private fun DependencyHandler.testImplementation(depName: String) =
    add("testImplementation", depName)
