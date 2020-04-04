package bloder.com.repository.repository

import arrow.core.Either
import bloder.com.repository.repository.contract.AlbumRepository

object ForAlbumRepository : AlbumRepository {

    override suspend fun fetchAlbums(userId: Int): Either<Nothing, List<String>> {
        return Either.Right(listOf(
            "Juliana",
            "Daniel"
        ))
    }
}