package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl

@TestCaseDslMarker
class UsersDsl(
    val uniqueTestId: String,
    var id: Int = 1,
    var name: String = "Test user $uniqueTestId"
) {

    val posts = mutableListOf<PostDsl>()

    fun post(block: PostDsl.() -> Unit = {}) {
        val postDsl = PostDsl(
            uniqueTestId = uniqueTestId,
            userId = id
        )
        postDsl.block()
        posts += postDsl
    }

}