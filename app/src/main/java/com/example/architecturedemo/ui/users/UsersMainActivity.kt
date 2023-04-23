package com.example.architecturedemo.ui.users

import com.example.architecturedemo.R
import com.example.architecturedemo.coordinator.FeatureNavigator
import com.example.architecturedemo.coordinator.FeatureNavigatorImpl
import com.example.architecturedemo.ui.base.BaseActivity
import com.example.architecturedemo.navigation.PostCoordinator
import com.example.architecturedemo.navigation.UserCoordinator

class UsersMainActivity : BaseActivity<UserCoordinator>() {

    private val featureNavigator: FeatureNavigator = FeatureNavigatorImpl(this)
    override val coordinator: UserCoordinator = UserCoordinator(featureNavigator)
    override val layoutResourceId: Int = R.layout.activity_basic_main
    override val graph: Int = R.navigation.user_nav_graph
    override val navHostId: Int = R.id.container

}