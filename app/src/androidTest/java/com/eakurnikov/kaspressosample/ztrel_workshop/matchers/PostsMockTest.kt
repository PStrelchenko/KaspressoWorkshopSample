package com.eakurnikov.kaspressosample.ztrel_workshop.matchers

import androidx.test.rule.ActivityTestRule
import com.eakurnikov.kaspressosample.view.main.MainActivity
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.kaspresso.MyBaseTestCase
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.MainScreen
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.PostsScreen
import org.junit.Rule
import org.junit.Test

class PostsMockTest : MyBaseTestCase() {

    private val mainScreen = MainScreen()
    private val postsScreen = PostsScreen()


    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)


    @Test
    fun postsScreenTest() {
        init {
            user {
                post {
                    id = 1L
                    title = "Test post #1"
                    body = "Test post body # 1"
                }
                post {
                    id = 2L
                    title = "Test post #2"
                    body = "Test post body # 2 bazinga"
                }
            }
        }.run {
            assert(data.posts[1].title == "Test post #2")

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


}