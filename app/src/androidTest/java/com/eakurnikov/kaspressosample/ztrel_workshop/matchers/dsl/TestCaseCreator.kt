package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl

import com.eakurnikov.kaspressosample.data.network.dto.PostDto
import com.eakurnikov.kaspressosample.data.network.dto.UserDto
import com.eakurnikov.kaspressosample.posts.mock.MockedPostsApi

object TestCaseCreator {

    fun createTestCase(testCaseDsl: TestCaseDsl): TestCase {
        MockedPostsApi.clear()

        val users = mutableListOf<UserDto>()
        val posts = mutableListOf<PostDto>()

        testCaseDsl.users.forEach { userDsl ->
            userDsl.posts.forEach { postDsl ->
                val postDto = PostDto(
                    id = postDsl.id,
                    title = postDsl.title,
                    body = postDsl.body,
                    userId = 1L
                )

                posts += MockedPostsApi.appendPostDto(postDto)
            }
        }

        return TestCase(
            uniqueTestId = testCaseDsl.uniqueTestId,
            users = users,
            posts = posts,
            initializationError = null
        )
    }


}