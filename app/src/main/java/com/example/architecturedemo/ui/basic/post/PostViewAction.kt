package com.example.architecturedemo.ui.basic.post

import com.example.architecturedemo.viewstate.ViewAction

sealed class PostViewAction: ViewAction {
    object ClickBack: PostViewAction()
    data class OpenPostDetail(val id: Int): PostViewAction()
}