package com.eakurnikov.kaspressosample.ztrel_workshop.matchers.pages

import android.view.View
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.eakurnikov.kaspressosample.R
import org.hamcrest.Matcher

class PostsScreen : Screen<PostsScreen>() {

    private val errorTextView = KTextView { withId(R.id.tv_posts_error) }

    private val postsList = KRecyclerView(
        builder = { withId(R.id.list_posts) },
        itemTypeBuilder = { itemType(::PostItem) }
    )


    fun scrollToBottom() {
        postsList.scrollToEnd()
    }

    fun checkItemOnLastPositionHasTitleWithBody(title: String, body: String) {
        postsList.childAt<PostItem>(postsList.getSize() - 1) {
            this.title.hasText(title)
            this.body.hasText(body)
        }
    }


    private class PostItem(parent: Matcher<View>) : KRecyclerItem<PostItem>(parent) {

        val title = KTextView(parent) { withId(R.id.tv_post_title) }
        val body = KTextView(parent) { withId(R.id.tv_post_body) }

    }

}