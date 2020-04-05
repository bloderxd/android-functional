package bloder.com.statemachine

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.sync.Mutex

internal typealias Reducer<S, A> = (S, A) -> S

fun <S: State, A: Action<S>> Flow<A>.asStateMachine(
    initialState: S,
    reducer: Reducer<S, A>
): Flow<S> = flow {
    val mutex = Mutex()
    var state = initialState
    collect {
        mutex.lock()
        state = reducer(state, it)
        mutex.unlock()
        emit(state)
    }
}