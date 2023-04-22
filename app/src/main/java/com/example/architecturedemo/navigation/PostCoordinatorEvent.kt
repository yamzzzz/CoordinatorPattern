package com.example.architecturedemo.navigation

import com.example.architecturedemo.coordinator.CoordinatorEvent

sealed class PostCoordinatorEvent: CoordinatorEvent {
    data class OpenDetail(val id: Int): PostCoordinatorEvent()
}