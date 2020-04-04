package bloder.com.repository.repository.contract

import arrow.core.Either

interface AlbumRepository {

    suspend fun fetchAlbums(userId: Int): Either<Nothing, List<String>>
}