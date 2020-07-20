package bloder.com.androidcore

import bloder.com.statemachine.Action
import bloder.com.statemachine.State
import bloder.com.statemachine.asStateMachine
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect

interface Model

open class StateModel<S : State, A : Action<S>>(
    val state: S,
    val action: ConflatedBroadcastChannel<A> = ConflatedBroadcastChannel(),
    val stateMachine: Flow<S> = action.asFlow().asStateMachine(
        initialState = state,
        reducer = { state, action -> action.transform(state) }
    )
) : Model

suspend fun <S : State, A : Action<S>> StateModel<S, A>.dispatch(action: A) {
    this.action.send(action)
    stateMachine.collect {}
}