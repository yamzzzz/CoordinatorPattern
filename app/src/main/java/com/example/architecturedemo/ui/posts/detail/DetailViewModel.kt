package com.example.architecturedemo.ui.posts.detail

import androidx.lifecycle.LiveData
import com.example.architecturedemo.model.Post
import com.example.architecturedemo.repository.APIService
import com.example.architecturedemo.ui.base.BaseViewModel

/* 
 * Created by Yamini on 15/5/18.
 */

class DetailViewModel : BaseViewModel<DetailViewAction>() {
    fun fetchPostById(id: Int): LiveData<Post> = APIService.getPostById(id)
    override fun postAction(action: DetailViewAction) {

    }
}
