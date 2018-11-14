package com.byteful.panther

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import com.byteful.panther.di.ApiModule
import com.byteful.panther.di.AppComponent
import com.byteful.panther.di.AppModule
import com.byteful.panther.di.DaggerAppComponent
import android.support.multidex.MultiDex



open class ProjectApplication:MultiDexApplication(){



    /*
   Dagger App component with scoop of whole application
   */

    val appComponent:AppComponent by lazy {
        createComponent()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        sInstance=this
        mConfig= ProjectConfig(this)
    }

    /*
    Method to return the Dagger App component
    PS: It will show depreciated till we use these components in our app
   */
    fun createComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .apiModule(ApiModule(this))
                .build()
    }


   override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

   companion object {
       private lateinit var sInstance: ProjectApplication

       private lateinit var mConfig: ProjectConfig

   }

}
