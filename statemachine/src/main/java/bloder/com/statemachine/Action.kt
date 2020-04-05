package bloder.com.statemachine

interface Action<S: State> {

    fun transform(state: S): S
}