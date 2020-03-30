package bloder.com.usecase

import arrow.Kind

interface UseCase<F, A> {

    suspend fun execute(): Kind<F, A>
}