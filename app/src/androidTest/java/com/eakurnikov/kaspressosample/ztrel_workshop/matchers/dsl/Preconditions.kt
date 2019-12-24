package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl


class Preconditions(
    private val testCase: TestCase
) {

    fun conditions(body: TestCase.() -> Unit): Preconditions {
        testCase.body()
        return this
    }

    fun testCase(body: TestCase.() -> Unit) {
        testCase.initializationError?.let { throw it }
        testCase.body()
        testCase.clean()
    }

}