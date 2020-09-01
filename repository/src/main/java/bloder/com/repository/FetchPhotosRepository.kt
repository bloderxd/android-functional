package bloder.com.repository

import arrow.core.Either
import com.bloder.core.Error

data class FetchPhotosRepositoryParams(val albumId: String)

object FetchPhotosRepository : Repository<FetchAlbumsRepositoryParams, List<String>> {

    override suspend fun FetchAlbumsRepositoryParams.load(): Either<Error, List<String>> {
        return Either.right(listOf())
    }
}