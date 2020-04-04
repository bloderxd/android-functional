package bloder.com.repository

import arrow.Kind
import bloder.com.repository.context.ForUserContext
import bloder.com.repository.context.contract.UserContext

interface Repository {

    suspend fun <F, A> withUser(context: suspend UserContext.() -> Kind<F, A>): Kind<F, A> = ForUserContext.context()
}

object ForRepository : Repository