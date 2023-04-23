package com.example.architecturedemo.ui.posts.post

import androidx.lifecycle.LiveData
import com.example.architecturedemo.coordinator.GlobalCoordinatorEvent
import com.example.architecturedemo.model.Post
import com.example.architecturedemo.repository.APIService
import com.example.architecturedemo.ui.base.BaseViewModel
import com.example.architecturedemo.navigation.PostCoordinatorEvent

/* 
 * Created by Yamini on 16/5/18.
 */

class PostViewModel : BaseViewModel<PostViewAction>() {
    fun fetchAllData(): LiveData<List<Post>> = APIService.getPostList()
    override fun postAction(action: PostViewAction) {
        when(action){
            is PostViewAction.ClickBack ->  sendCoordinatorEvent(GlobalCoordinatorEvent.Back)
            is PostViewAction.OpenPostDetail -> sendCoordinatorEvent(PostCoordinatorEvent.OpenDetail(action.id))
        }
    }
}