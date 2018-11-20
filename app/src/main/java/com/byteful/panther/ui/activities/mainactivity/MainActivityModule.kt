package com.byteful.panther.ui.activities.mainactivity

import dagger.Module
import dagger.Provides

/**
 * Created by Shami on 5/6/2018.
 */

@Module
public class MainActivityModule{


    @Provides
    fun mainActivityRepository(): MainActivityRepository {
        return MainActivityRepository()
    }

    @Provides
    fun mainActivityFactory(mainActivityRepository: MainActivityRepository): MainActivityFactory {

        return MainActivityFactory(mainActivityRepository)
    }

}