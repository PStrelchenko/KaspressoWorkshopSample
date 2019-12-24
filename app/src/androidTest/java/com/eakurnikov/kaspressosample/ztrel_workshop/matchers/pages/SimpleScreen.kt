package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.eakurnikov.kaspressosample.R


class SimpleScreen : Screen<SimpleScreen>() {

    private val title = KTextView { withId(R.id.tv_simple_title) }


    fun checkTitleDisplayed(titleText: String) {
        title.isVisible()
        title.hasText(titleText)
    }

}