package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.matchers

import android.graphics.drawable.ColorDrawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

class BackgroundColorMatcher(
    @ColorRes private val colorResId: Int
) : TypeSafeMatcher<View>() {

    companion object {
        fun withBackgroundColor(@ColorRes colorResId: Int) = BackgroundColorMatcher(colorResId)
    }


    override fun describeTo(description: Description?) {
        description?.appendText("with background color [$colorResId]")
    }

    override fun matchesSafely(item: View?): Boolean {
        if (colorResId == -1) {
            return item?.background == null
        }

        return item?.let { itemView ->
            val expectedColor = ContextCompat.getColor(itemView.context, colorResId)

            (itemView.background as? ColorDrawable)?.color == expectedColor
        } ?: false
    }

}