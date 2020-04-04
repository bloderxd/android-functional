package bloder.com.repository.context.contract

import bloder.com.repository.repository.contract.AlbumRepository

interface UserContext {

    fun forAlbums(): AlbumRepository
}