package spartons.com.koinmvvm.backend

import retrofit2.http.GET
import retrofit2.http.Query
import spartons.com.koinmvvm.activities.main.data.MovieCollection


/**
 * Ahsen Saeed}
 * ahsansaeed067@gmail.com}
 * 10/24/19}
 */

interface ServiceUtil {

    @GET(value = "popular")
    suspend fun popularMovies(
        @Query(
            value = "api_key",
            encoded = false
        ) apiKey: String, @Query(value = "page") pageNumber: Int = 1
    ): MovieCollection
}