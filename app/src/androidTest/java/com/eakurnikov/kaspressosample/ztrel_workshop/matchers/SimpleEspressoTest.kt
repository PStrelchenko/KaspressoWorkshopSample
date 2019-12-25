package com.eakurnikov.kaspressosample.ztrel_workshop.matchers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.eakurnikov.kaspressosample.R
import com.eakurnikov.kaspressosample.view.main.MainActivity
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.matchers.BackgroundColorMatcher.Companion.withBackgroundColor
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.MainScreen
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.SimpleScreen
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test


class SimpleEspressoTest : TestCase() {

    private val mainScreen = MainScreen()
    private val simpleScreen = SimpleScreen()

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)


    @Test
    fun myTest() {
        init {
            // data creation
        }.run {
            step("Нажали на кнопку Simple screen") {
                onView(
                    withId(R.id.btn_simple_screen)
                ).check(matches(isClickable()))
                    .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
                    .check(matches(withText(R.string.simple_screen)))
                    .perform(click())
            }


            onView(
                allOf(
                    withId(R.id.tv_simple_title),
                    withText("Simple title")
                )
            ).check(matches(isDisplayed()))

            onView(
                withId(R.id.et_simple)
            ).perform(typeText("Kaspresso"))
                .check(matches(withText("Kaspresso")))

            onView(isRoot()).perform(closeSoftKeyboard())

            onView(
                allOf(
                    isDescendantOfA(withId(R.id.simple_root)),
                    hasSibling(withText(R.string.delete)),
                    withBackgroundColor(R.color.colorPrimary)
                )
            ).check(matches(withText("Next")))
                .perform(click())

            onView(withId(R.id.tv_second_title)).check(matches(withText("Kaspresso")))

            onView(isRoot()).perform(pressBack())

            onView(withId(R.id.btn_simple_delete)).perform(click())

            onView(
                withId(R.id.btn_simple_next)
            ).perform(click())

            onView(withId(R.id.tv_second_title)).check(matches(withText("")))
        }
    }

}