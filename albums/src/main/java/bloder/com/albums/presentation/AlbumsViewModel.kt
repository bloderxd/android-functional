package bloder.com.albums.presentation

import arrow.core.Either
import bloder.com.albums.statemachine.UpdateNamesAction
import bloder.com.androidcore.BaseViewModel
import bloder.com.androidcore.dispatch
import bloder.com.usecase.albums.FetchAlbumsUseCase

class AlbumsViewModel(
    private val fetchAlbums: FetchAlbumsUseCase
) : BaseViewModel<AlbumModel>() {

    override val model: AlbumModel = AlbumModel()

    fun loadAlbums() = io {
        when(val albums = !effect { getAlbums() }) {
            is Either.Right -> !effect { updateTexts(albums.b[0], albums.b[1]) }
            else -> !effect { println("") }
        }
    }

    private suspend fun getAlbums() = fetchAlbums("1")

    private suspend fun updateTexts(first: String, second: String) = model.dispatch(UpdateNamesAction(first, second))
}
