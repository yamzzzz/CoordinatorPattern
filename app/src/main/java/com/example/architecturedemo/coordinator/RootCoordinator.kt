package com.example.architecturedemo.coordinator

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

abstract class RootCoordinator(val featureNavigator: FeatureNavigator) {
    var navController: NavController? = null

    var activity: FragmentActivity? = null

    var navHostFragment: NavHostFragment? = null

    abstract fun onEvent(event: Any): Boolean

    abstract fun onStart(): NavigationDestination
    fun finishWithResult(resultIntent: Intent?) {
        activity?.setResult(Activity.RESULT_OK, resultIntent)
        activity?.finish()
    }

    fun registerNavigationListener(listener: (Int) -> Unit) {
        navController?.addOnDestinationChangedListener { _, destination, _ ->
            listener.invoke(destination.id)
        }
    }
    fun clear() {
        navController = null
        activity = null
        navHostFragment = null
    }
}