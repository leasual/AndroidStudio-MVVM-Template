//apply plugin: 'kotlin-kapt'

android {
	compileSdkVersion 27
    defaultConfig {
    	targetSdkVersion 27
        versionCode 1000
        versionName "1.0.0"
        buildConfigField("String", "BASE_URL", "\"https://gank.io/api/\"")
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
                    details.useVersion support
                }
            }
        }
    }
}

android.applicationVariants.all { variant ->
    def appName
    if (project.hasProperty("applicationName")) {
        appName	=	applicationName
    } else {
        appName	=	parent.name
    }
    appName	= appName + "V" + variant.versionName + "(" + variant.versionCode + ")" + variant.flavorName + ".apk"
    variant.outputs.all {
        outputFileName	=	appName
    }
}

dependencies {
    implementation	"com.android.support:appcompat-v7:$support"
    implementation	"com.android.support:recyclerview-v7:$support"
    //dagger
    implementation	"com.google.dagger:dagger:$dagger"
    implementation	"com.google.dagger:dagger-android:$dagger"
    implementation	"com.google.dagger:dagger-android-support:$dagger"
    //layout
    implementation	"com.android.support.constraint:constraint-layout:$constraint_layout"
    //life cycle
    implementation	"android.arch.lifecycle:runtime:$lifecycle"
    implementation	"android.arch.lifecycle:extensions:$lifecycle"
    implementation	"android.arch.lifecycle:common-java8:$lifecycle"
    //retrofit
    implementation	"com.squareup.retrofit2:retrofit:$retrofit"
    implementation	"com.squareup.retrofit2:converter-gson:$retrofit"
    implementation	"com.squareup.retrofit2:retrofit-mock:$retrofit"
    implementation	"com.squareup.retrofit2:adapter-rxjava2:$retrofit"
    implementation	"com.squareup.okhttp3:logging-interceptor:$okhttp_logging_interceptor"
    //rxjava
    implementation	"io.reactivex.rxjava2:rxjava:$rxjava2"
    implementation	"io.reactivex.rxjava2:rxandroid:$rx_android"
    //glide
    implementation	"com.github.bumptech.glide:glide:$glide"
    //kpt
    kapt	"com.google.dagger:dagger-compiler:$dagger"
    kapt	"com.google.dagger:dagger-android-processor:$dagger"
    kapt	"android.arch.lifecycle:compiler:$lifecycle"
    kapt	"com.android.databinding:compiler:$databinding"
    kapt	"com.github.bumptech.glide:compiler:$glide"
}

