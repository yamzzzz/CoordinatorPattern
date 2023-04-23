package com.example.architecturedemo.navigation

import com.example.architecturedemo.coordinator.CoordinatorEvent

sealed class PostMainCoordinatorEvent: CoordinatorEvent {
    data class Open(val id: Int): PostMainCoordinatorEvent()
}