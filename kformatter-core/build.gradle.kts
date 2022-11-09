@file:Suppress("UnstableApiUsage", "UNUSED_VARIABLE")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.library")
}

kotlin {
    android {
        publishAllLibraryVariants()
    }
    jvm()
    js(IR) {
        browser()
        nodejs()
    }
    ios()
    watchos()
    tvos()
    macosArm64()
    macosX64()
    iosSimulatorArm64()
    watchosSimulatorArm64()
    tvosSimulatorArm64()

    sourceSets {
        val commonMain by getting
        val commonTest by getting

        val androidMain by getting
        val androidTest by getting

        val jvmMain by getting
        val jvmTest by getting

        val jsMain by getting
        val jsTest by getting

        val darwinMain by creating {
            dependsOn(commonMain)
        }
        val darwinTest by creating {
            dependsOn(commonTest)
        }
        val iosMain by getting {
            dependsOn(darwinMain)
        }
        val iosTest by getting {
            dependsOn(darwinTest)
        }
        val watchosMain by getting {
            dependsOn(darwinMain)
        }
        val watchosTest by getting {
            dependsOn(darwinTest)
        }
        val tvosMain by getting {
            dependsOn(darwinMain)
        }
        val tvosTest by getting {
            dependsOn(darwinTest)
        }
        val macosArm64Main by getting {
            dependsOn(darwinMain)
        }
        val macosArm64Test by getting {
            dependsOn(darwinTest)
        }
        val iosSimulatorArm64Main by getting {
            dependsOn(darwinMain)
        }
        val iosSimulatorArm64Test by getting {
            dependsOn(darwinTest)
        }
        val watchosSimulatorArm64Main by getting {
            dependsOn(darwinMain)
        }
        val watchosSimulatorArm64Test by getting {
            dependsOn(darwinTest)
        }
        val tvosSimulatorArm64Main by getting {
            dependsOn(darwinMain)
        }
        val tvosSimulatorArm64Test by getting {
            dependsOn(darwinTest)
        }
    }
}

android {
    compileSdk = 33
    namespace = "com.pschsch.kformatter.core"
    sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 14
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    libraryVariants.all {
        generateBuildConfigProvider?.get()?.enabled = false
    }
}