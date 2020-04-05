package bloder.com.albums.statemachine

import androidx.lifecycle.MutableLiveData
import bloder.com.statemachine.State

data class AlbumState(
    val first: MutableLiveData<String> = MutableLiveData(),
    val second: MutableLiveData<String> = MutableLiveData()
) : State