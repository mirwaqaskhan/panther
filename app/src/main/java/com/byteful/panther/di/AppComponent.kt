package com.byteful.panther.di

import com.byteful.panther.ProjectApplication
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Shami on 5/6/2018.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class,ApiModule::class))
public interface AppComponent{

    fun inject(projectApplication: ProjectApplication)


}