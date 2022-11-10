@file:Suppress("UnstableApiUsage", "UNUSED_VARIABLE")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.library")
    id("kotlin-parcelize")
    id("maven-publish")
}

group = "com.pschsch"
version = "0.0.1-alpha02"

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

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test:1.7.20")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
            }
        }

        val serializableMain by creating {
            dependsOn(commonMain)
        }

        val serializableTest by creating {
            dependsOn(commonTest)
            dependsOn(serializableMain)
        }

        val nonSerializableMain by creating {
            dependsOn(commonMain)
        }

        val nonSerializableTest by creating {
            dependsOn(commonTest)
            dependsOn(nonSerializableMain)
        }

        val parcelableMain by creating {
            dependsOn(commonMain)
        }

        val parcelableTest by creating {
            dependsOn(commonTest)
            dependsOn(parcelableMain)
        }

        val nonParcelableMain by creating {
            dependsOn(commonMain)
        }

        val nonParcelableTest by creating {
            dependsOn(commonTest)
            dependsOn(nonParcelableMain)
        }

        val androidMain by getting {
            dependsOn(commonMain)
            dependsOn(serializableMain)
            dependsOn(parcelableMain)
        }
        val androidTest by getting {
            dependsOn(commonTest)
            dependsOn(serializableTest)
            dependsOn(parcelableTest)
        }

        val jvmMain by getting {
            dependsOn(commonMain)
            dependsOn(nonParcelableMain)
            dependsOn(serializableMain)
        }
        val jvmTest by getting {
            dependsOn(commonTest)
            dependsOn(serializableTest)
            dependsOn(nonParcelableTest)
        }
        val darwinMain by creating {
            dependsOn(commonMain)
            dependsOn(nonSerializableMain)
            dependsOn(nonParcelableMain)
        }
        val darwinTest by creating {
            dependsOn(commonTest)
            dependsOn(nonSerializableTest)
            dependsOn(nonParcelableTest)
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