package com.eakurnikov.kaspressosample.idling

import androidx.annotation.Nullable
import androidx.test.espresso.IdlingResource
import java.util.concurrent.atomic.AtomicBoolean


abstract class AbstractIdlingResource : IdlingResource {

    @Nullable
    @Volatile
    private var callback: IdlingResource.ResourceCallback? = null

    private val isIdleNowAtomic = AtomicBoolean(true)


    override fun getName(): String {
        return this.javaClass.name
    }

    override fun isIdleNow(): Boolean {
        return isIdleNowAtomic.get()
    }

    override fun registerIdleTransitionCallback(callback: IdlingResource.ResourceCallback?) {
        this.callback = callback
    }


    open fun setIdleState(isIdleNow: Boolean) {
        this.isIdleNowAtomic.set(isIdleNow)
        if (isIdleNow && callback != null) {
            callback?.onTransitionToIdle()
        }
    }

}