package bloder.com.androidcore

import androidx.lifecycle.ViewModel
import arrow.fx.ForIO
import arrow.fx.IO
import arrow.fx.extensions.fx
import arrow.fx.typeclasses.ConcurrentSyntax
import bloder.com.statemachine.Action
import bloder.com.statemachine.State
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

typealias ConcurrentIO = ConcurrentSyntax<ForIO>

abstract class BaseViewModel<S : State> : ViewModel(), CoroutineScope by CoroutineScope(Dispatchers.Main) {

    abstract val state: S

    abstract val machine: Flow<S>

    protected fun <T> io(c: suspend ConcurrentIO.() -> T) = launch { IO.fx { c() }.suspended() }

    protected suspend fun <A : Action<S>> ConflatedBroadcastChannel<A>.onAction(action: A) {
        send(action)
        machine.collect {}
    }
}