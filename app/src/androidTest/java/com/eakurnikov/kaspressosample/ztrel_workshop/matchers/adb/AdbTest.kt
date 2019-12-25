package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.adb

import androidx.test.rule.ActivityTestRule
import com.eakurnikov.kaspressosample.view.main.MainActivity
import com.eakurnikov.kaspressosample.ztrel_workshop.matchers.kaspresso.MyBaseTestCase
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class AdbTest : MyBaseTestCase() {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, true, true)


    @Test
    fun myAdbTest() {
        init {
            //
        }.run {
            step("Execute pm list package") {
                val command = "pm list package"

                val result = adbServer.performShell(command)

                Assert.assertTrue("package:${device.targetContext.packageName}" in result.first())
            }
        }
    }

}