package com.jollypanda.gvent_databinding

import android.support.multidex.MultiDexApplication
import com.jollypanda.gvent_databinding.di.component.AppComponent
import com.jollypanda.gvent_databinding.di.component.DaggerAppComponent
import com.jollypanda.gvent_databinding.di.module.AppModule
import com.jollypanda.gvent_databinding.di.module.ModelsModule
import com.jollypanda.gvent_databinding.di.module.NetworkModule

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
class App : MultiDexApplication() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = initDI()
    }

    private fun initDI(): AppComponent =
            DaggerAppComponent.builder()
                    .appModule(AppModule(applicationContext))
                    .networkModule(NetworkModule())
                    .modelsModule(ModelsModule())
                    .build()
}