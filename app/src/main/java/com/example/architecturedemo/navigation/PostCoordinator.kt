package com.example.architecturedemo.navigation

import com.example.architecturedemo.R
import com.example.architecturedemo.coordinator.GlobalCoordinatorEvent
import com.example.architecturedemo.coordinator.NavigationDestination
import com.example.architecturedemo.coordinator.RootCoordinator
import com.example.architecturedemo.ui.basic.detail.DetailFragmentArgs

class PostCoordinator: RootCoordinator() {

    override fun onEvent(event: Any): Boolean {
      when (event) {
          is GlobalCoordinatorEvent.Back -> if (navController?.popBackStack() == false) {
              activity?.finish()
          }
          is PostCoordinatorEvent.OpenDetail -> openPostDetail(event.id)
      }
        return true
    }

    override fun onStart(): NavigationDestination {
       return NavigationDestination(R.id.post_fragment)
    }

    private fun openPostDetail(id: Int) {
        val args = DetailFragmentArgs(id).toBundle()
        navController?.navigate(R.id.detailFragment, args)
    }

}