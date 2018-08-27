apply plugin: 'kotlin-kapt'

android {
    compileSdkVersion build_versions.target_sdk
    buildToolsVersion build_versions.build_tools
    defaultConfig {
        applicationId "com.wesoft.mvvmachitecture"
        minSdkVersion build_versions.min_sdk
        targetSdkVersion build_versions.target_sdk
        versionCode 1000
        versionName "1.0.0"
        buildConfigField "String","BASE_URL","\"https://gank.io/api/\""
        multiDexEnabled true
    }
    dataBinding {
        enabled = true
    }
    
    signingConfigs {
        config {
            //keyAlias "$KEY_ALIAS"
            //keyPassword "$KEY_PASSWORD"
            //storeFile file("$KEYSTORE_FILE")
            //storePassword "$KEYSTORE_PASSWORD"
        }
    }

    buildTypes {
        debug {
            //signingConfig signingConfigs.config
            minifyEnabled false
            zipAlignEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    
    flavorDimensions "mode"
    productFlavors {
        dev {

        }
        uat {

        }
        prod {

        }
    }

    kapt {
        generateStubs = true
    }

    configurations.all {
        resolutionStrategy.eachDependency { DependencyResolveDetails details ->
            def requested = details.requested
            if (requested.group == 'com.android.support') {
                if (!requested.name.startsWith("multidex")) {
                    details.useVersion build_versions.support_version
                }
            }
        }
    }
}

android.applicationVariants.all { variant ->
    def appName
    if (project.hasProperty("applicationName")) {
        appName = applicationName
    } else {
        appName = parent.name
    }
    appName = appName + "V" + variant.versionName + "(" + variant.versionCode + ")" + variant.flavorName + ".apk"
    variant.outputs.all {
        outputFileName = appName
    }
}

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    ///kotlin
    implementation deps.kotlin.stdlib
    //support
    implementation deps.support.app_compat
    implementation deps.support.recyclerview
    //dagger
    implementation deps.dagger.runtime
    implementation deps.dagger.android
    implementation deps.dagger.android_support
    //layout
    implementation deps.constraint_layout
    //life cycle
    implementation deps.lifecycle.runtime
    implementation deps.lifecycle.extensions
    implementation deps.lifecycle.java8
    //retrofit
    implementation deps.retrofit.runtime
    implementation deps.retrofit.gson
    implementation deps.retrofit.adapter
    implementation deps.okhttp_logging_interceptor
    //rxjava
    implementation deps.rxjava.runtime
    implementation deps.rxjava.rxandroid
    //glide
    implementation deps.glide.runtime
    //kpt
    kapt deps.dagger.android_support_compiler
    kapt deps.dagger.compiler
    kapt deps.lifecycle.compiler
    kapt deps.databinding
    kapt deps.glide.compiler
}
