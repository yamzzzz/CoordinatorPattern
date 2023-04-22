package com.example.architecturedemo.ui.basic.detail

import com.example.architecturedemo.viewstate.ViewAction

sealed class DetailViewAction: ViewAction {
    object ClickBack: DetailViewAction()
}