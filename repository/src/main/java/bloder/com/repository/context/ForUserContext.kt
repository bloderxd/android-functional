package bloder.com.repository.context

import bloder.com.repository.context.contract.UserContext
import bloder.com.repository.repository.ForAlbumRepository
import bloder.com.repository.repository.contract.AlbumRepository

object ForUserContext : UserContext {

    override fun forAlbums(): AlbumRepository = ForAlbumRepository
}