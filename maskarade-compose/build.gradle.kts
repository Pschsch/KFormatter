@file:Suppress("UnstableApiUsage")

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("kotlin-parcelize")
    id("maven-publish")
    id("com.jfrog.artifactory") //internal use. Can be safely removed to run locally
    id("com.pschsch.artifactory.publish") //internal use. Can be safely removed to run locally
}

group = "com.pschsch"
version = "0.0.1-alpha14"

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

artifactoryPublishConfig { //internal use. Can be safely removed to run locally
    kotlinMultiplatform {
        includeAndroid = true
        includeIOS = true
        includeJVM = true
    }
}