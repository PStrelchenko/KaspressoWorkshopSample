package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl

import com.eakurnikov.kaspressosample.data.network.dto.PostDto
import com.eakurnikov.kaspressosample.data.network.dto.UserDto

class TestCaseData(
    val uniqueTestId: String,
    val users: List<UserDto>,
    val posts: List<PostDto>,
    val initializationError: Throwable?
) {

    fun clean() {
        // nothing to do by default
    }

}