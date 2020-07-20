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

abstract class BaseViewModel<M : Model> : ViewModel(), CoroutineScope by CoroutineScope(Dispatchers.Main) {

    abstract val model: M

    protected fun <T> io(c: suspend ConcurrentIO.() -> T) = launch { IO.fx { c() }.suspended() }
}