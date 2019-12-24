package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.actions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher


class ScrollToBottomAction : ViewAction {

    override fun getDescription(): String {
        return "Scroll RecyclerView to bottom"
    }

    override fun getConstraints(): Matcher<View> {
        return allOf<View>(
            isAssignableFrom(RecyclerView::class.java),
            isDisplayed()
        )
    }

    override fun perform(uiController: UiController?, view: View?) {
        val recyclerView = view as? RecyclerView
        val itemCount = recyclerView?.adapter?.itemCount ?: 0

        val position = itemCount.minus(1)
        recyclerView?.scrollToPosition(position)
        uiController?.loopMainThreadUntilIdle()
    }

}