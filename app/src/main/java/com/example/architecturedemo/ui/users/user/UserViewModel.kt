package com.example.architecturedemo.ui.users.user

import androidx.lifecycle.LiveData
import com.example.architecturedemo.coordinator.GlobalCoordinatorEvent
import com.example.architecturedemo.model.User
import com.example.architecturedemo.repository.APIService
import com.example.architecturedemo.ui.base.BaseViewModel
import com.example.architecturedemo.navigation.PostCoordinatorEvent
import com.example.architecturedemo.ui.posts.post.UserViewAction

/* 
 * Created by Yamini on 16/5/18.
 */

class UserViewModel : BaseViewModel<UserViewAction>() {
    fun fetchAllData(): LiveData<List<User>> = APIService.getUsers()
    override fun postAction(action: UserViewAction) {
        when(action){
            is UserViewAction.ClickBack ->  sendCoordinatorEvent(GlobalCoordinatorEvent.Back)
            is UserViewAction.OpenPostDetail -> sendCoordinatorEvent(PostCoordinatorEvent.OpenDetail(action.id))
            else -> {}
        }
    }
}