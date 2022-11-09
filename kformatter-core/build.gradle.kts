@file:Suppress("UnstableApiUsage", "UNUSED_VARIABLE")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.library")
    id("kotlin-parcelize")
}

kotlin {
    android {
        publishAllLibraryVariants()
    }
    jvm()
    ios()
    watchos()
    tvos()
    macosArm64()
    macosX64()
    iosSimulatorArm64()
    watchosSimulatorArm64()
    tvosSimulatorArm64()
    linuxX64()
    mingwX64()

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test:1.7.20")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
            }
        }

        val androidMain by getting
        val androidTest by getting

        val nonAndroidMain by creating {
            dependsOn(commonMain)
        }
        val nonAndroidTest by creating {
            dependsOn(commonTest)
            dependsOn(nonAndroidMain)
        }

        val jvmMain by getting {
            dependsOn(nonAndroidMain)
        }
        val jvmTest by getting {
            dependsOn(nonAndroidTest)
        }

        val darwinMain by creating {
            dependsOn(nonAndroidMain)
        }
        val darwinTest by creating {
            dependsOn(nonAndroidTest)
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
        val macosX64Main by getting {
            dependsOn(darwinMain)
        }
        val macosX64Test by getting {
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
        val linuxX64Main by getting {
            dependsOn(nonAndroidMain)
        }
        val linuxX64Test by getting {
            dependsOn(nonAndroidTest)
        }
        val mingwX64Main by getting {
            dependsOn(nonAndroidMain)
        }
        val mingwX64Test by getting {
            dependsOn(nonAndroidTest)
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