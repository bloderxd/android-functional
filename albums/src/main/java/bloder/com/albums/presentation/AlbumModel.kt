package bloder.com.albums.presentation

import bloder.com.albums.statemachine.AlbumAction
import bloder.com.albums.statemachine.AlbumState
import bloder.com.androidcore.StateModel

class AlbumModel : StateModel<AlbumState, AlbumAction>(AlbumState())