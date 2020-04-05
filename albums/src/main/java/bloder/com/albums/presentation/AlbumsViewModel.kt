package bloder.com.albums.presentation

import arrow.core.Either
import bloder.com.albums.domain.fetchAlbums
import bloder.com.albums.statemachine.AlbumState
import bloder.com.albums.statemachine.UpdateNamesAction
import bloder.com.albums.statemachine.albumAction
import bloder.com.androidcore.BaseViewModel
import bloder.com.statemachine.asStateMachine
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class AlbumsViewModel : BaseViewModel<AlbumState>() {

    override val state: AlbumState = AlbumState()

    override val machine: Flow<AlbumState> = albumAction.asFlow().asStateMachine(
        initialState = state,
        reducer = { state, action -> action.transform(state) }
    )

    fun loadAlbums() = io {
        when(val albums = !effect { getAlbums() }) {
            is Either.Right -> !effect { updateTexts(albums.b[0], albums.b[1]) }
            else -> !effect { println("") }
        }
    }

    private suspend fun getAlbums() = fetchAlbums(1).run()

    private suspend fun updateTexts(first: String, second: String) = albumAction.onAction(UpdateNamesAction(first, second))
}
