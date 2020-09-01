package bloder.com.usecase.albums

import arrow.core.Either
import bloder.com.repository.FetchAlbumsRepository
import bloder.com.repository.FetchAlbumsRepositoryParams
import bloder.com.repository.Repository
import bloder.com.usecase.fetch
import com.bloder.core.Error

class FetchAlbumsUseCase(
    private val repository: Repository<FetchAlbumsRepositoryParams, List<String>> = FetchAlbumsRepository
) : Repository<FetchAlbumsRepositoryParams, List<String>> by repository {

    suspend operator fun invoke(userId: String): Either<Error, List<String>> = fetch(FetchAlbumsRepositoryParams(userId))
}