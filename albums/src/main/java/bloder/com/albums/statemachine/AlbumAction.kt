package bloder.com.albums.statemachine

import bloder.com.statemachine.ViewAction

sealed class AlbumAction : ViewAction<AlbumState>

data class UpdateNamesAction(private val first: String, private val second: String) : AlbumAction() {

    override fun AlbumState.updateView() {
        first.value = this@UpdateNamesAction.first
        second.value = this@UpdateNamesAction.second
    }
}