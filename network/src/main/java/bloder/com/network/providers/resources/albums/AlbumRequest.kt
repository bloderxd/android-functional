package bloder.com.network.providers.resources.albums

import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumRequest {

    @GET("users/{user_id}/albums")
    suspend fun getAlbums(@Path("user_id") userId: Int): List<AlbumRequest>
}