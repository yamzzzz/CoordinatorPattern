package com.example.architecturedemo.ui.posts

import androidx.lifecycle.LiveData
import com.example.architecturedemo.coordinator.GlobalCoordinatorEvent
import com.example.architecturedemo.model.Post
import com.example.architecturedemo.navigation.PostCoordinatorEvent
import com.example.architecturedemo.repository.APIService
import com.example.architecturedemo.ui.base.BaseViewModel
import com.example.architecturedemo.ui.posts.post.PostViewAction

class PostMainViewModel: BaseViewModel<PostMainViewAction>() {
    override fun postAction(action: PostMainViewAction) {

    }
}