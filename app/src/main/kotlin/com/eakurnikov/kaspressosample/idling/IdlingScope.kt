package com.eakurnikov.kaspressosample.idling

import java.util.concurrent.atomic.AtomicReference


fun isReleaseBuild(): Boolean {
    return false
}


interface IdlingScope {
    val postsIdlingResource: PostsIdlingResource
}


val idlingContainer = AtomicReference<IdlingScope>()

fun idling(action: IdlingScope.() -> Unit) {
    if (!isReleaseBuild()) {
        idlingContainer.get()?.action()
    }
}