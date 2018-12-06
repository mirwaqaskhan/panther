package com.byteful.panther.di

import com.byteful.panther.ProjectApplication
import com.byteful.panther.ui.activities.mainactivity.MainActivity
import com.byteful.panther.ui.activities.mainactivity.MainActivityRepository
import com.byteful.panther.ui.fragment.detailfragment.FragmentDetail
import com.byteful.panther.ui.fragment.homefragment.FragmentHome
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Shami on 5/6/2018.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class,ApiModule::class))
public interface AppComponent{

    fun inject(projectApplication: ProjectApplication)
    fun inject(mainActivityRepository: MainActivityRepository)
    fun inject(mainActivity: MainActivity)
    fun inject(fragmentHome: FragmentHome)
    fun inject(fragmentDetail: FragmentDetail)
}