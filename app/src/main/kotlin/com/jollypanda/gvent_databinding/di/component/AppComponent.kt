package com.jollypanda.gvent_databinding.di.component

import com.jollypanda.gvent_databinding.data.remote.utils.OkHttpClientFactory
import com.jollypanda.gvent_databinding.di.module.AppModule
import com.jollypanda.gvent_databinding.di.module.ModelsModule
import com.jollypanda.gvent_databinding.di.module.NetworkModule
import com.jollypanda.gvent_databinding.presentation.MainPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class, ModelsModule::class))
interface AppComponent {
    fun injectTo(okHttpClientFactory: OkHttpClientFactory)
    fun injectTo(mainPresenter: MainPresenter)
}