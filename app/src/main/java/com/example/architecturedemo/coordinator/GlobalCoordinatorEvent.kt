package com.example.architecturedemo.coordinator

sealed class GlobalCoordinatorEvent : CoordinatorEvent {
    object Back : GlobalCoordinatorEvent()
}