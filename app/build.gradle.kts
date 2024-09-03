plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.nk.reviewsapptemp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nk.reviewsapptemp"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

//    implementation("com.google.android.play:review:2.0.1")
    implementation(libs.rewiew.java)
//    implementation("com.google.android.play:review-ktx:2.0.1")
    implementation(libs.rewiew.ktx)
}