
plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.hw04_gymlog_v300"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.hw04_gymlog_v300"
        minSdk = 34
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.core)
    implementation(libs.androidx.junit)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


    androidTestImplementation ("androidx.test:core:1.5.0")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")

    implementation(libs.room.runtime)
    annotationProcessor( libs.room.compiler)
}