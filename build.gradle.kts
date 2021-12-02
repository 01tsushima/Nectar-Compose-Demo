// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    extra.apply{
        set("compose_version",Dependencies.composeVersion)
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:${Dependencies.gradle}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dependencies.kotlinVersion}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Dependencies.hiltCoreVersion}")
    }
}

tasks.register(name = "type",type = Delete::class){
    delete(rootProject.buildDir)
}