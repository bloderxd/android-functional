package bloder.com.androidcore

import androidx.lifecycle.ViewModel
import arrow.fx.ForIO
import arrow.fx.IO
import arrow.fx.extensions.fx
import arrow.fx.typeclasses.ConcurrentSyntax
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

typealias ConcurrentIO = ConcurrentSyntax<ForIO>

open class BaseViewModel : ViewModel(), CoroutineScope by CoroutineScope(Dispatchers.Main) {

    protected fun <T> io(c: suspend ConcurrentIO.() -> T) = launch { IO.fx { c() }.suspended() }
}