package spartons.com.koinmvvm.activities.main.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import spartons.com.koinmvvm.activities.main.viewModel.MovieViewModel

/**
 * Ahsen Saeed}
 * ahsansaeed067@gmail.com}
 * 10/24/19}
 */

val movieModule = module {

    viewModel {
        MovieViewModel(get())
    }

}