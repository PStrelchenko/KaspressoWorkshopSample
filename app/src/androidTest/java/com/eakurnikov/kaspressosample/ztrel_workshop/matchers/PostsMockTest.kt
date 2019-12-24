package com.eakurnikov.kaspressosample.ztrel_workshop.matchers

import androidx.test.rule.ActivityTestRule
import com.eakurnikov.kaspressosample.data.network.dto.PostDto
import com.eakurnikov.kaspressosample.posts.mock.MockedPostsApi
import com.eakurnikov.kaspressosample.view.main.MainActivity
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.MainScreen
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages.PostsScreen
import org.junit.Rule
import org.junit.Test

class PostsMockTest {

    private val mainScreen = MainScreen()
    private val postsScreen = PostsScreen()


    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun postsScreenTest() {
        MockedPostsApi.clear()
        MockedPostsApi.appendPostDto(
            PostDto(1, 1, "Test post #1", "Test post body #1")
        )
        MockedPostsApi.appendPostDto(
            PostDto(2, 1, "Test post #2", "Test post body #2")
        )


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