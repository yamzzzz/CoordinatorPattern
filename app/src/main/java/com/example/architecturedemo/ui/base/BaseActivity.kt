package com.example.architecturedemo.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.example.architecturedemo.coordinator.CoordinatorHost
import com.example.architecturedemo.coordinator.NavigationDestination
import com.example.architecturedemo.coordinator.RootCoordinator

/**
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
abstract class BaseActivity<C : RootCoordinator> : AppCompatActivity(),
    CoordinatorHost<C> {
    protected abstract val layoutResourceId: Int

    @get:NavigationRes
    abstract val graph: Int

    @get:IdRes
    abstract val navHostId: Int


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(layoutResourceId)

        coordinator.navController = findNavController(navHostId)
        coordinator.activity = this

        val host = supportFragmentManager.findFragmentById(navHostId) as NavHostFragment
        coordinator.navHostFragment = host

        setupNavigationGraph(graphId = graph, host = host, startDestination = coordinator.onStart())
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

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(navHostId).navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        coordinator.clear()
    }
}