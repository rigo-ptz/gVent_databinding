package com.jollypanda.gvent_databinding.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jollypanda.gvent_databinding.BuildConfig
import com.jollypanda.gvent_databinding.data.remote.Api
import com.jollypanda.gvent_databinding.data.remote.utils.OkHttpClientFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit.Builder, clientFactory: OkHttpClientFactory, gson: Gson): Api =
            retrofit
                    .baseUrl(BuildConfig.BASE_URL)
                    .client(clientFactory.buildClient())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(Api::class.java)

    @Provides
    @Singleton
    fun provideClientFactory() = OkHttpClientFactory()

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val builder = GsonBuilder()
                .setDateFormat("dd.MM.yyyy HH:mm")
        return builder.create()
    }
}