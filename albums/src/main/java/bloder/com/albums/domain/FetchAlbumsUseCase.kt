package bloder.com.albums.domain

import bloder.com.repository.ForRepository
import bloder.com.repository.Repository
import bloder.com.usecase.albums.FetchAlbumsUseCase
import bloder.com.usecase.albums.fetchAlbumsUseCase

fun fetchAlbums(userId: Int, repository: Repository = ForRepository): FetchAlbumsUseCase = fetchAlbumsUseCase {
    repository.withUser {
        forAlbums().fetchAlbums(userId)
    }
}