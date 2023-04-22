package com.example.architecturedemo.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.architecturedemo.coordinator.CoordinatorHost
import com.example.architecturedemo.coordinator.RootCoordinator
import com.example.architecturedemo.extension.getCoordinatorHost
import com.example.architecturedemo.extension.hideKeyboard
import com.example.architecturedemo.helper.EventObserver
import com.example.architecturedemo.viewstate.ViewAction

abstract class BaseFragment<VA: ViewAction,  VM : BaseViewModel<VA>>: Fragment() {
    protected abstract val layoutResourceId: Int
    protected abstract val viewModel: VM

    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(layoutResourceId, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.coordinatorEvent.observe(viewLifecycleOwner, EventObserver {
            getCoordinatorHost().coordinator.navController
            if (!getCoordinatorHost().coordinator.onEvent(it)) {
                getActivityCoordinator().onEvent(it)
            }
        })
    }
    protected fun postAction(action: VA) {
        viewModel.postAction(action)
    }

    fun View.postClickAction(action: VA) {
        setOnClickListener { postAction(action) }
    }

    private fun getActivityCoordinator(): RootCoordinator {
        return (requireActivity() as CoordinatorHost<*>).coordinator
    }

    override fun onResume() {
        super.onResume()
        hideKeyboard()
    }

}