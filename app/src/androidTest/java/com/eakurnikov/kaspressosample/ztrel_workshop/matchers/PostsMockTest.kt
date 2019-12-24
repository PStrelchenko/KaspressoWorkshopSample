package com.eakurnikov.kaspressosample.ztrel_workshop.matchers

import androidx.test.rule.ActivityTestRule
import com.eakurnikov.kaspressosample.view.main.MainActivity
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl.Preconditions
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl.preconditions
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.MainScreen
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.PostsScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PostsMockTest {

    private val mainScreen = MainScreen()
    private val postsScreen = PostsScreen()


    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    private lateinit var preconditions: Preconditions

    @Before
    fun beforeEachTest() {
        preconditions = preconditions {
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
        }
    }

    @Test
    fun postsScreenTest() {
        preconditions.testCase {
            assert(posts[1].title == "Test post #2")

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