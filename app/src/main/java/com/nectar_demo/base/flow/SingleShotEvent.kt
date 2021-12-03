package com.nectar_demo.base.flow

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class SingleShotEvent<E> {

    private val _events = Channel<E>()
    val events = _events.receiveAsFlow()

    suspend fun send(element: E) = _events.send(element)

    fun offer(element: E) = _events.trySend(element)
}