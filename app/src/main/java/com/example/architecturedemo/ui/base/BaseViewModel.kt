package com.example.architecturedemo.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturedemo.coordinator.CoordinatorEvent
import com.example.architecturedemo.helper.Event
import com.example.architecturedemo.helper.asLiveData
import com.example.architecturedemo.viewstate.ViewAction

/**
 * Created by Ahmed Abd-Elmeged on 4/22/20.
 */
abstract class BaseViewModel<VA : ViewAction> : ViewModel() {


    private val _coordinatorEvent = MutableLiveData<Event<CoordinatorEvent>>()
    val coordinatorEvent = _coordinatorEvent.asLiveData()

    abstract fun postAction(action: VA)


    protected fun <E : CoordinatorEvent> sendCoordinatorEvent(event: E) {
        _coordinatorEvent.value = Event(event)
    }
}