// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies {
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath("com.android.tools.build:gradle:3.4.0-alpha10")
        classpath("com.google.gms:google-services:4.2.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.11")
        classpath("com.android.databinding:compiler:3.2.0-alpha10")
        classpath("net.sf.proguard:proguard-gradle:6.0.3")
    }
}


allprojects {

    repositories {
        jcenter()
        google()
        maven {
            url = uri("https://jitpack.io")
            content {
                includeGroup("com.github.scottyab")
            }
        }
    }
}

tasks.register("clean",Delete::class) {
    delete(rootProject.buildDir)
}
