package bloder.com.usecase.photos

import arrow.core.Either
import bloder.com.repository.FetchPhotosRepositoryParams
import bloder.com.repository.Repository
import bloder.com.usecase.fetch
import com.bloder.core.Error

class FetchPhotosUseCase(
    private val repository: Repository<FetchPhotosRepositoryParams, List<String>>
) : Repository<FetchPhotosRepositoryParams, List<String>> by repository {

    suspend fun invoke(albumId: String): Either<Error, List<String>> = fetch(FetchPhotosRepositoryParams(albumId))
}