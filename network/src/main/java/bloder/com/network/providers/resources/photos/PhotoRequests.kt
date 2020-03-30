package bloder.com.network.providers.resources.photos

import bloder.com.network.providers.resources.photos.data.PhotoPayload
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotoRequests {

    @GET("albums/{albumId}/photos") suspend fun getPhotos(@Path(value = "albumId") albumId: String) : List<PhotoPayload>
}