package com.example.architecturedemo.ui.posts.detail

import com.example.architecturedemo.viewstate.ViewAction

sealed class DetailViewAction: ViewAction {
    object ClickBack: DetailViewAction()
}