package com.jollypanda.gvent_databinding.data.remote.utils

import android.content.Context
import android.os.Build
import android.provider.Settings
import android.util.Log
import com.jollypanda.gvent_databinding.App
import com.jollypanda.gvent_databinding.BuildConfig
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.net.ssl.SSLContext

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
class OkHttpClientFactory {

    @Inject
    lateinit var context: Context

    init {
        App.appComponent.injectTo(this)
    }

    fun buildClient() = buildWith(null)

    private val CONNECTION_TIMEOUT_S: Long = 5
    private val READ_TIMEOUT_S: Long = 5

    private fun  buildWith(decoration: ((OkHttpClient.Builder) -> Unit)?): OkHttpClient =
            with(OkHttpClient.Builder()) {
                setTimeouts(this)
                setInterceptors(this)
                decoration?.invoke(this)
                build()
            }

    private fun setTimeouts(builder: OkHttpClient.Builder) {
        builder.connectTimeout(CONNECTION_TIMEOUT_S, TimeUnit.SECONDS)
        builder.readTimeout(READ_TIMEOUT_S, TimeUnit.SECONDS)
    }

    private fun setInterceptors(builder: OkHttpClient.Builder) {
        builder.interceptors().clear()
        builder.networkInterceptors().clear()

        if (BuildConfig.DEBUG)
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    }

    private fun getDeviceId() =
            Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
}