package bloder.com.usecase

import arrow.core.Either
import bloder.com.repository.Repository
import com.bloder.core.Error

suspend fun <T, R, P> T.fetch(p: P): Either<Error, R> where T : Repository<P, R> = p.load()