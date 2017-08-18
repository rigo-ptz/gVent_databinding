package com.jollypanda.gvent_databinding.data.repositories

import com.jollypanda.gvent_databinding.App
import com.jollypanda.gvent_databinding.data.remote.Api
import com.jollypanda.gvent_databinding.data.remote.response.User
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author Yamushev Igor
 * @since  18.08.17
 */
class UserRepository {

    @Inject
    lateinit var api: Api

    init {
        App.appComponent.injectTo(this)
    }

    fun loadUsersList(): Single<List<User>> =
            api.getUsers()
                    .observeOn(Schedulers.computation())
}