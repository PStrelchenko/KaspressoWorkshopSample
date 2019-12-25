object Versions {

    // Remember that "kotlin" && "androidTools" versions duplicated
    // in build.gradle of buildSrc module.

    const val kotlinVersion = "1.3.61"
    const val androidToolsVersion = "3.5.3"
    const val buildToolsVersion = "28.0.3"
    const val minSdkVersion = 21

    const val targetSdkVersion = 28
    const val compileSdkVersion = 28
}

object Libs {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"

    val dagger = DaggerLibraries
    val androidX = AndroidXLibraries
    val viewModel = ViewModelLibraries
    val network = NetworkLibraries
    val rx = RxLibraries
    val room = RoomLibraries
    val tests = TestsLibraries
    val uiTests = UiTestsLibraries


    object DaggerLibraries {
        private const val daggerVersion = "2.20"

        const val daggerCore = "com.google.dagger:dagger:$daggerVersion"
        const val daggerAndroid = "com.google.dagger:dagger-android:$daggerVersion"
        const val daggerSupport = "com.google.dagger:dagger-android-support:$daggerVersion"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
        const val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:$daggerVersion"
    }

    object AndroidXLibraries {
        private const val androidXVersion = "1.1.0"
        private const val materialVersion = "1.0.0"
        private const val constraintVersion = "1.1.3"

        const val appCompat = "androidx.appcompat:appcompat:$androidXVersion"
        const val materialDesign = "com.google.android.material:material:$materialVersion"
        const val recyclerView = "androidx.recyclerview:recyclerview:$androidXVersion"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintVersion"
    }

    object ViewModelLibraries {
        private const val lifecycleVersion = "2.1.0"

        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleVersion"
        const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        const val lifecycleRx = "androidx.lifecycle:lifecycle-reactivestreams:$lifecycleVersion"
    }

    object NetworkLibraries {
        private const val okHttpVersion = "3.12.0"
        private const val retrofitVersion = "2.5.0"

        const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
        const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"

        // Retrofit
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val retrofitRx2Adapter = "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    }

    object RxLibraries {
        private const val rxjavaVersion = "2.2.3"
        private const val rxKotlinVersion = "2.3.0"
        private const val rxAndroidVersion = "2.1.1"

        const val rxJava = "io.reactivex.rxjava2:rxjava:$rxjavaVersion"
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:$rxKotlinVersion"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:$rxAndroidVersion"
    }

    object RoomLibraries {
        private const val roomVersion = "2.2.2"

        const val roomCore = "androidx.room:room-runtime:$roomVersion"
        const val roomRxJava = "androidx.room:room-rxjava2:$roomVersion"
        const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
    }

    object TestsLibraries {
        private const val junitVersion = "4.12"
        private const val junitExtVersion = "1.1.0"
        private const val testingSupportLibraryVersion = "1.1.0-alpha4"

        const val junit4 = "junit:junit:$junitVersion"
        const val junitExt = "androidx.test.ext:junit:$junitExtVersion"
        const val rules = "androidx.test:rules:$testingSupportLibraryVersion"
        const val runner = "androidx.test:runner:$testingSupportLibraryVersion"
    }

    object UiTestsLibraries {
        private const val espressoVersion = "3.2.0"
        private const val kaspressoVersion = "1.0.6"
        private const val kakaoVersion = "2.2.0"

        const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
        const val espressoWeb = "androidx.test.espresso:espresso-web:$espressoVersion"
        const val espressoContrib = "androidx.test.espresso:espresso-contrib:$espressoVersion"
        const val espressoIntents = "androidx.test.espresso:espresso-intents:$espressoVersion"
        const val espressoIdling = "androidx.test.espresso.idling:idling-concurrent:$espressoVersion"
        const val kaspresso = "ru.hh.kaspresso:kaspresso:$kaspressoVersion"
        const val kakao = "com.agoda.kakao:kakao:$kakaoVersion"
    }
}

object Plugins {

    private const val dokkaVersion = "0.9.18"


    const val androidTools = "com.android.tools.build:gradle:${Versions.androidToolsVersion}"
    const val dokka = "org.jetbrains.dokka:dokka-android-gradle-plugin:$dokkaVersion"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"

    val detekt = DetektPlugin

    object DetektPlugin {
        private const val detektVersion = "1.0.0-RC14"

        const val detektToolVersion = detektVersion
        const val detektFormatting = "io.gitlab.arturbosch.detekt:detekt-formatting:$detektVersion"
        const val detektCli = "io.gitlab.arturbosch.detekt:detekt-cli:$detektVersion"
    }
}