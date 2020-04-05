package bloder.com.albums.statemachine

import bloder.com.statemachine.Action
import kotlinx.coroutines.channels.ConflatedBroadcastChannel

sealed class AlbumAction : Action<AlbumState>

data class UpdateNamesAction(private val first: String, private val second: String) : AlbumAction() {

    override fun transform(state: AlbumState): AlbumState = state.apply {
        first.value = this@UpdateNamesAction.first
        second.value = this@UpdateNamesAction.second
    }
}

val albumAction: ConflatedBroadcastChannel<AlbumAction> = ConflatedBroadcastChannel()