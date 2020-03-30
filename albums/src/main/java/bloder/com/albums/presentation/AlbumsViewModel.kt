package bloder.com.albums.presentation

import androidx.lifecycle.MutableLiveData
import arrow.core.Either
import bloder.com.albums.domain.fetchAlbums
import bloder.com.androidcore.BaseViewModel
import bloder.com.androidcore.ConcurrentIO

class AlbumsViewModel() : BaseViewModel() {

    val first: MutableLiveData<String> = MutableLiveData()
    val second: MutableLiveData<String> = MutableLiveData()

    fun loadAlbums() = io {
        when(val albums = !getAlbums()) {
            is Either.Right -> {
                first.postValue(albums.b[0])
                second.postValue(albums.b[1])
            }
            else -> !effect { println("") }
        }
    }

    private fun ConcurrentIO.getAlbums() = effect {
        fetchAlbums(1).execute()
    }
}
