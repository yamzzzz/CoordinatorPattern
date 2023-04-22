package com.example.architecturedemo.coordinator


interface CoordinatorHost<C : RootCoordinator> {

    val coordinator: C
}