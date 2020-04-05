package bloder.com.androidcore

import bloder.com.statemachine.Action
import bloder.com.statemachine.State
import kotlinx.coroutines.channels.ConflatedBroadcastChannel

abstract class DataBindingModel<S : State, A : Action<S>> {
    abstract val state: S
    val action: ConflatedBroadcastChannel<A> = ConflatedBroadcastChannel()
}