package bloder.com.usecase

import arrow.Kind

interface UseCase<F, A> {

    suspend fun run(): Kind<F, A>
}