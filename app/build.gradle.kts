plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.crypticsamsara.weather"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.crypticsamsara.weather"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    // implementation(libs.androidx.navigation.compose.jvmstubs)
    implementation(libs.firebase.crashlytics)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

// dependencies for Compose navigation
    implementation("androidx.navigation:navigation-compose:2.9.2")


    // FireBase
    // Firebase BoM manages compatible versions
    implementation(platform("com.google.firebase:firebase-bom:34.0.0"))

    // Firebase Authentication
    implementation("com.google.firebase:firebase-auth-ktx:23.2.1")

    // classPath for fireBase Crash analytics
    implementation("com.google.firebase:firebase-analytics")

    // Retrofit Dependencies
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // LifeCycle and viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.2")

    // Icons
    implementation("androidx.compose.material:material-icons-core:1.7.8")
    implementation("androidx.compose.material:material-icons-extended:1.7.8")

    // Animated navigation
    implementation("com.google.accompanist:accompanist-navigation-animation:0.36.0")



// OkHttp
    implementation("com.squareup.okhttp3:okhttp:5.1.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
// Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")
// Lifecycle components
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.2")

    // Dagger Hilt for Dependency Injection
    implementation ("com.google.dagger:hilt-android:2.57")
    kapt ("com.google.dagger:hilt-android-compiler:2.57")

    // For viewmodel injection
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")



}