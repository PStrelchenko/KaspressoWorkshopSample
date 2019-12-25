package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl


class Preconditions(
    private val testCaseData: TestCaseData
) {

    fun conditions(body: TestCaseData.() -> Unit): Preconditions {
        testCaseData.body()
        return this
    }

    fun testCase(body: TestCaseData.() -> Unit) {
        testCaseData.initializationError?.let { throw it }
        testCaseData.body()
        testCaseData.clean()
    }

}