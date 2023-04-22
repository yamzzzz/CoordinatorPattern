package com.example.architecturedemo.ui.basic

import android.os.Bundle
import com.example.architecturedemo.R
import com.example.architecturedemo.ui.base.BaseActivity
import com.example.architecturedemo.navigation.PostCoordinator

class BasicMainActivity : BaseActivity<PostCoordinator>() {

    override val coordinator: PostCoordinator = PostCoordinator()
    override val layoutResourceId: Int = R.layout.activity_basic_main
    override val graph: Int = R.navigation.basic_nav_graph
    override val navHostId: Int = R.id.container

}