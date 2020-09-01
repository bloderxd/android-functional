package bloder.com.repository

import arrow.core.Either
import com.bloder.core.Error

interface Repository<P, T> {

    suspend fun P.load(): Either<Error, T>
}