package bloder.com.statemachine

interface Action<S: State> {

    fun S.transform(): S
}