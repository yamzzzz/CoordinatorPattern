package com.example.architecturedemo.navigation

import com.example.architecturedemo.R
import com.example.architecturedemo.coordinator.FeatureNavigator
import com.example.architecturedemo.coordinator.GlobalCoordinatorEvent
import com.example.architecturedemo.coordinator.NavigationDestination
import com.example.architecturedemo.coordinator.RootCoordinator
import com.example.architecturedemo.ui.posts.detail.DetailFragmentArgs

class UserCoordinator(featureNavigator: FeatureNavigator): RootCoordinator(featureNavigator) {

    override fun onEvent(event: Any): Boolean {
      when (event) {
          is GlobalCoordinatorEvent.Back -> if (navController?.popBackStack() == false) {
              activity?.finish()
          }
      }
        return true
    }

    override fun onStart(): NavigationDestination {
       return NavigationDestination(R.id.userFragment)
    }

}