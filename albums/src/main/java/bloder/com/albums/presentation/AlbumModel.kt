package bloder.com.albums.presentation

import bloder.com.albums.statemachine.AlbumAction
import bloder.com.albums.statemachine.AlbumState
import bloder.com.androidcore.DataBindingModel

class AlbumModel : DataBindingModel<AlbumState, AlbumAction>() {
    override val state: AlbumState = AlbumState()
}