package bloder.com.albums.presentation

import bloder.com.albums.statemachine.AlbumAction
import bloder.com.albums.statemachine.AlbumState
import bloder.com.androidcore.DataBindingModel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel

class AlbumModel : DataBindingModel<AlbumState, AlbumAction> {
    override val state: AlbumState = AlbumState()
    override val action: ConflatedBroadcastChannel<AlbumAction> = ConflatedBroadcastChannel()
}