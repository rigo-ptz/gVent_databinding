package com.jollypanda.gvent_databinding.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
@Module
class AppModule(val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

}