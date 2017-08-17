package com.jollypanda.gvent_databinding.di.module

import com.jollypanda.gvent_databinding.model.UserModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
@Module
class ModelsModule {

    @Provides
    @Singleton
    fun providesUserModel() = UserModel()

}