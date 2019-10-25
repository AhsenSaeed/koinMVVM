package spartons.com.koinmvvm.activities.main.viewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.single_movie_item.*
import spartons.com.koinmvvm.R
import spartons.com.koinmvvm.activities.main.data.MovieCollection

/**
 * Ahsen Saeed}
 * ahsansaeed067@gmail.com}
 * 10/24/19}
 */

class MovieAdapterViewHolder constructor(
    override val containerView: View,
    private val picasso: Picasso
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    private fun setImageFavorite(isFavorite: Boolean) {
        if (isFavorite)
            movie_favorite_image_view.setImageResource(R.drawable.ic_star_golden_28dp)
        else
            movie_favorite_image_view.setImageResource(R.drawable.ic_star_border_golden_28dp)
    }

    fun bind(movie: MovieCollection.Movie) {
        picasso.load(MOVIE_POSTER_BASE_URL.plus(movie.posterUrl))
            .fit()
            .centerCrop()
            .into(movie_poster_image_view)
        movie_name_text_view.text = movie.name
        movie_release_date_text_view.text = movie.releaseDate
        setImageFavorite(movie.isFavorite)
        movie_favorite_image_view.setOnClickListener {
            movie.isFavorite = !movie.isFavorite
            setImageFavorite(movie.isFavorite)
        }
    }

    companion object {
        private const val MOVIE_POSTER_BASE_URL = "http://image.tmdb.org/t/p/w185"

        fun create(
            parent: ViewGroup,
            picasso: Picasso
        ): MovieAdapterViewHolder {
            return MovieAdapterViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.single_movie_item,
                    parent,
                    false
                ), picasso
            )
        }
    }
}
