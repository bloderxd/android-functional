package bloder.com.albums.domain

import arrow.core.Either
import bloder.com.usecase.albums.FetchAlbumsUseCase
import bloder.com.usecase.albums.fetchAlbumsUseCase

fun fetchAlbums(userId: Int): FetchAlbumsUseCase = fetchAlbumsUseCase {
    Either.Right(listOf(
        "Juliana",
        "Daniel"
    ))
}