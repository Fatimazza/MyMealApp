package id.fatimazza.mymealapp

import android.app.Application
import id.fatimazza.mymealapp.data.DefaultAppContainer
import id.fatimazza.mymealapp.data.MealsAppContainer

class MyMealsApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: MealsAppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}

