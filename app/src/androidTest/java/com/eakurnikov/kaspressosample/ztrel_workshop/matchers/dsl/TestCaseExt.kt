package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl


fun preconditions(block: TestCaseDsl.() -> Unit): Preconditions {
    val testCaseDsl = TestCaseDsl().apply(block)
    val testCase = TestCaseCreator.createTestCase(testCaseDsl)
    return Preconditions(testCase)
}


fun markupTest() {


}
