package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl

import java.util.*

@TestCaseDslMarker
class TestCaseDsl {

    val uniqueTestId = UUID.randomUUID().toString()
    val users = mutableListOf<UsersDsl>()

    fun user(block: UsersDsl.() -> Unit = {}) {
        val userDsl = UsersDsl(
            uniqueTestId = uniqueTestId
        )
        userDsl.block()
        users += userDsl
    }

}