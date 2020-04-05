package bloder.com.albums.presentation

import bloder.com.albums.statemachine.AlbumAction
import bloder.com.albums.statemachine.AlbumState
import bloder.com.androidcore.DataBindingModel
import kotlinx.coroutines.channels.ConflatedBroadcastChannel

class AlbumModel : DataBindingModel<AlbumState, AlbumAction> {

    override fun state(): AlbumState = AlbumState()

    override fun action(): ConflatedBroadcastChannel<AlbumAction> = ConflatedBroadcastChannel()
}