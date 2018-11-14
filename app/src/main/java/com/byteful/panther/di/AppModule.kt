package com.byteful.panther.di

import android.content.Context
import android.net.ConnectivityManager
import com.byteful.panther.ProjectApplication
import com.byteful.panther.api.PantharApiService
import com.byteful.panther.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


/**
 * Created by Shami on 5/6/2018.
 */

@Module
class AppModule(var application: ProjectApplication){


    /*
     Method to return context of application
     */

    @Provides
    @Singleton
    fun provideContext(): Context
    {
        return application
    }


    /*
     Method to call for server apis
     */

    @Provides
    @Singleton
    fun getServerApi(retrofit: Retrofit): PantharApiService
    {
        return retrofit.create(PantharApiService::class.java)
    }


    /*
    Method to Check Network states
     */

    @Provides
    @Singleton
    @Named(Constants.isNetwork)
    fun isOnline(context: Context): Boolean {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnectedOrConnecting
    }



}