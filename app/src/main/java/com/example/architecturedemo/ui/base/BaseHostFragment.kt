package com.example.architecturedemo.ui.base

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import com.example.architecturedemo.coordinator.CoordinatorHost
import com.example.architecturedemo.coordinator.NavigationDestination
import com.example.architecturedemo.coordinator.RootCoordinator
import com.example.architecturedemo.viewstate.ViewAction

/**
 * To support child coordinators/flows in a single activity setup.
 * Created by Ahmed Abd-Elmeged on 6/29/20.
 */
abstract class BaseHostFragment<
        VA : ViewAction,
        VM : BaseViewModel<VA>,
        C : RootCoordinator
        > : BaseFragment<VA, VM>(), CoordinatorHost<C> {

    @get:NavigationRes
    abstract val graph: Int

    @get:IdRes
    abstract val navHostId: Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coordinator.activity = requireActivity()

        val host = childFragmentManager.findFragmentById(navHostId) as NavHostFragment
        coordinator.navController = host.navController
        coordinator.navHostFragment = host

        if (coordinator.navController?.currentDestination == null) {
            setupNavigationGraph(
                graphId = graph,
                host = host,
                startDestination = coordinator.onStart()
            )
        }
    }

    private fun setupNavigationGraph(
        @NavigationRes graphId: Int,
        host: NavHostFragment,
        startDestination: NavigationDestination
    ) {
        val inflater = host.navController.navInflater
        val graph = inflater.inflate(graphId)
        graph.setStartDestination(startDestination.navId)
        host.navController.setGraph(graph, startDestination.navigationArguments)
    }

    override fun onDestroy() {
        super.onDestroy()
        coordinator.clear()
    }
}