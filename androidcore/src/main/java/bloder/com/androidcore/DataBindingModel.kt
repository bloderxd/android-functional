package bloder.com.androidcore

import bloder.com.statemachine.Action
import bloder.com.statemachine.State
import kotlinx.coroutines.channels.ConflatedBroadcastChannel

interface DataBindingModel<S : State, A : Action<S>> {
    fun state(): S
    fun action(): ConflatedBroadcastChannel<A>
}