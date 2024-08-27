plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    //kotlin("kapt")
    //alias(libs.plugins.kapt)
    id("org.jetbrains.kotlin.kapt")
    alias(libs.plugins.hilt)
    id("io.sentry.android.gradle") version "4.11.0"
}

android {
    namespace = "com.example.dos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.dos"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation (libs.retrofit)

    implementation(libs.glide)
    kapt(libs.glide.compiler)


    // Hilt dependencies
    implementation(libs.hilt)
    kapt("com.google.dagger:hilt-compiler:2.52")

    // For instrumentation tests
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.52")
    kaptAndroidTest(libs.hilt.compiler)

    // For local unit tests
    testImplementation(libs.hilt.android.testing)
    kaptTest("com.google.dagger:hilt-compiler:2.52")

}

kapt {
    correctErrorTypes = true
}