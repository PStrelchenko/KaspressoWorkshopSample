package com.eakurnikov.kaspressosample.ztrel_workshop.matchers

import androidx.test.rule.ActivityTestRule
import com.eakurnikov.kaspressosample.view.main.MainActivity
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.MainScreen
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.PostsScreen
import org.junit.Rule
import org.junit.Test


class PostsEspressoTest {

    private val mainScreen = MainScreen()
    private val postsScreen = PostsScreen()


    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun postsScreenTest() {
        mainScreen.navigateToPostsScreen()

        Thread.sleep(3_000L)

        postsScreen {
            scrollToBottom()
            checkItemOnLastPositionHasTitleWithBody(
                title = "Last post",
                body = "Perfect body"
            )
        }

    }

}