package spartons.com.koinmvvm.activities.main.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Ahsen Saeed}
 * ahsansaeed067@gmail.com}
 * 10/24/19}
 */

@Serializable
data class MovieCollection(@SerialName(value = "page") val page: Int, @SerialName(value = "results") val movies: ArrayList<Movie>) {

    @Serializable
    data class Movie(
        @SerialName(value = "id") val id: Long, @SerialName(value = "poster_path") val posterUrl: String, @SerialName(
            value = "original_title"
        ) val name: String, @SerialName(
            value = "vote_average"
        ) val rating: Float, @SerialName(value = "overview") val description: String, @SerialName(
            value = "release_date"
        ) val releaseDate: String
    ) {
        var isFavorite: Boolean = false
    }
}