@file:Suppress("UnstableApiUsage")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("kotlin-parcelize")
    id("maven-publish")
}

group = findProperty("group")!!
version = findProperty("version")!!

kotlin {
    android {
        publishAllLibraryVariants()
    }
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.maskaradeCore)
                compileOnly(compose.foundation)
                compileOnly(compose.runtime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation("org.jetbrains.kotlin:kotlin-test:1.7.20")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
        }
        val androidTest by getting {
            dependsOn(commonTest)
        }
        val jvmMain by getting {
            dependsOn(commonMain)
        }
        val jvmTest by getting {
            dependsOn(commonTest)
        }
    }
}

android {
    compileSdk = 32
    namespace = "com.pschsch.kformatter.core"
    sourceSets.getByName("main").manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    libraryVariants.all {
        generateBuildConfigProvider?.get()?.enabled = false
    }
}