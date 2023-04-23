package com.example.architecturedemo.ui.posts

import com.example.architecturedemo.viewstate.ViewAction

sealed class PostMainViewAction: ViewAction {
    object OpenUser : PostMainViewAction()
}