package bloder.com.statemachine

interface ViewAction<S : State> : Action<S> {

    override fun S.transform(): S = this.apply { updateView() }

    fun S.updateView()
}