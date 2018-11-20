package com.byteful.panther.di

import com.byteful.panther.ProjectApplication
import com.byteful.panther.ui.activities.mainactivity.MainActivityComponent
import com.byteful.panther.ui.activities.mainactivity.MainActivityModule
import com.byteful.panther.ui.activities.mainactivity.MainActivityRepository
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Shami on 5/6/2018.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class,ApiModule::class))
public interface AppComponent{

    fun inject(projectApplication: ProjectApplication)
    fun plus(mainActivityModule: MainActivityModule): MainActivityComponent
    fun inject(mainActivityRepository: MainActivityRepository)

}