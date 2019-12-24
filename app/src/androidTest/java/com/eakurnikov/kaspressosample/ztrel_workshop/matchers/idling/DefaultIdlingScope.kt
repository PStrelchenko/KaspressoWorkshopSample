package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.idling

import com.eakurnikov.kaspressosample.idling.IdlingScope
import com.eakurnikov.kaspressosample.idling.PostsIdlingResource


fun defaultIdlingScope(): IdlingScope {
    return object : IdlingScope {
        override val postsIdlingResource: PostsIdlingResource = PostsIdlingResource()
    }
}