package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.eakurnikov.kaspressosample.R


class MainScreen : Screen<MainScreen>() {

    private val btnSimpleScreen = KButton { withId(R.id.btn_simple_screen) }
    private val btnFlakyScreen = KButton { withId(R.id.btn_flaky_screen) }
    private val btnPostsScreen = KButton { withId(R.id.btn_posts_screen) }
    private val btnWebScreen = KButton { withId(R.id.btn_webview_screen) }
    private val btnDocLocScreen = KButton { withId(R.id.btn_doc_loc_screen) }


    fun navigateToSimpleScreen() {
        btnSimpleScreen.click()
    }

    fun navigateToPostsScreen() {
        btnPostsScreen.click()
    }

    fun checkTitleDisplayed(titleText: String) {
        //
    }

}