package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.kaspresso

import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl.TestCaseCreator
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl.TestCaseData
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.dsl.TestCaseDsl
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.BaseTestCase

abstract class MyBaseTestCase : BaseTestCase<TestCaseDsl, TestCaseData>(
    kaspressoBuilder = Kaspresso.Builder.default(),
    dataProducer = { block ->
        val testCaseDsl = TestCaseDsl().apply { block?.invoke(this) }
        val testCase = TestCaseCreator.createTestCase(testCaseDsl)
        testCase
    }
)