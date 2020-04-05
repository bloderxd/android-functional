package bloder.com.androidcore

import androidx.lifecycle.ViewModel
import arrow.fx.ForIO
import arrow.fx.IO
import arrow.fx.extensions.fx
import arrow.fx.typeclasses.ConcurrentSyntax
import bloder.com.statemachine.Action
import bloder.com.statemachine.State
import bloder.com.statemachine.asStateMachine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

typealias ConcurrentIO = ConcurrentSyntax<ForIO>

abstract class BaseViewModel<S : State, A : Action<S>, M : DataBindingModel<S, A>> : ViewModel(), CoroutineScope by CoroutineScope(Dispatchers.Main) {

    abstract val model: M

    private val machine: Flow<S> = model.action().asFlow().asStateMachine(
        initialState = model.state(),
        reducer = { state, action -> action.transform(state) }
    )

    protected fun <T> io(c: suspend ConcurrentIO.() -> T) = launch { IO.fx { c() }.suspended() }

    protected suspend fun onAction(action: A) {
        model.action().send(action)
        machine.collect {}
    }
}