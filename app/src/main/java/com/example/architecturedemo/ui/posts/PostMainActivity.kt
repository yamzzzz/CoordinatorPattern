package com.example.architecturedemo.ui.posts

import android.os.Bundle

import com.example.architecturedemo.R
import com.example.architecturedemo.coordinator.FeatureNavigator
import com.example.architecturedemo.coordinator.FeatureNavigatorImpl
import com.example.architecturedemo.navigation.PostCoordinator
import com.example.architecturedemo.ui.base.BaseActivity

class PostMainActivity : BaseActivity<PostCoordinator>() {

    private val featureNavigator: FeatureNavigator = FeatureNavigatorImpl(this)
    override val coordinator: PostCoordinator = PostCoordinator(featureNavigator)
    override val layoutResourceId: Int = R.layout.activity_basic_main
    override val graph: Int = R.navigation.post_nav_graph
    override val navHostId: Int = R.id.container

}