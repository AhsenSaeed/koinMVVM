package spartons.com.koinmvvm.backend

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import spartons.com.koinmvvm.activities.main.di.movieModule
import spartons.com.koinmvvm.di.picassoModule
import spartons.com.koinmvvm.di.retrofitModule


/**
 * Ahsen Saeed}
 * ahsansaeed067@gmail.com}
 * 10/24/19}
 */

class MyCustomApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyCustomApp)
            modules(listOf(retrofitModule, picassoModule, movieModule))
        }
    }
}