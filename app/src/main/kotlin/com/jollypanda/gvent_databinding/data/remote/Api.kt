package com.jollypanda.gvent_databinding.data.remote

import com.jollypanda.gvent_databinding.data.remote.response.User
import io.reactivex.Single
import retrofit2.http.GET

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
interface Api {
    @GET("users.json")
    fun getUsers(): Single<List<User>>
}