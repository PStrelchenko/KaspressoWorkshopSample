package com.eakurnikov.kaspressosample.ztrel_workshop.matchers

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.eakurnikov.kaspressosample.R
import com.eakurnikov.kaspressosample.view.main.MainActivity
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.actions.ScrollToBottomAction
import org.junit.Rule
import org.junit.Test


class PostsEspressoTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

//    @Before
//    fun beforeEachTest() {
//        idlingContainer.set(defaultIdlingScope())
//        idling { IdlingRegistry.getInstance().register(postsIdlingResource) }
//    }
//
//    @After
//    fun afterEachTest() {
//        idling { IdlingRegistry.getInstance().unregister(postsIdlingResource) }
//    }


    @Test
    fun postsScreenTest() {
        onView(withId(R.id.btn_posts_screen)).perform(click())

        onView(withId(R.id.list_posts)).perform(ScrollToBottomAction())

        onView(withText("Perfect body")).check(matches(isDisplayed()))
    }

}