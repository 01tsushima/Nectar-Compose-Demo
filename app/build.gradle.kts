import Dependencies.activityComposeVersion
import Dependencies.composeVersion
import Dependencies.constraintLayoutComposeVersion
import Dependencies.gsonVersion
import Dependencies.hiltComposeNavigationVersion
import Dependencies.hiltCoreVersion
import Dependencies.hiltVersion
import Dependencies.pagingComposeVersion
import Dependencies.timberVersion


plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    // https://dagger.dev/hilt/
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.nectar_demo"
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = composeVersion
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:${Dependencies.coreKtxVersion}")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${Dependencies.kotlinVersion}")
    implementation("androidx.appcompat:appcompat:${Dependencies.appCompatVersion}")

    // compose
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.constraintlayout:constraintlayout-compose:$constraintLayoutComposeVersion")
    implementation("androidx.activity:activity-compose:$activityComposeVersion")
    implementation("androidx.paging:paging-compose:$pagingComposeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")

    // other
    implementation("com.jakewharton.timber:timber:$timberVersion")
    implementation("com.google.code.gson:gson:$gsonVersion")

    // hilt
    implementation("com.google.dagger:hilt-android:${hiltCoreVersion}")
    kapt("com.google.dagger:hilt-compiler:${hiltCoreVersion}")
    kapt("androidx.hilt:hilt-compiler:${hiltVersion}")
    implementation("androidx.hilt:hilt-navigation-compose:${hiltComposeNavigationVersion}")
}

kapt {
    correctErrorTypes = true
}