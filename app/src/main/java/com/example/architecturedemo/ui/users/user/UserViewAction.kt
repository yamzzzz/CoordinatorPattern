package com.example.architecturedemo.ui.posts.post

import com.example.architecturedemo.viewstate.ViewAction

sealed class UserViewAction: ViewAction {
    object ClickBack: UserViewAction()
    data class OpenPostDetail(val id: Int): UserViewAction()
}