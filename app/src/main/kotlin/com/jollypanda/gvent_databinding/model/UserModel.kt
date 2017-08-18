package com.jollypanda.gvent_databinding.model

import com.jollypanda.gvent_databinding.data.remote.response.User
import com.jollypanda.gvent_databinding.data.repositories.UserRepository
import io.reactivex.Single

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
class UserModel {

    val repository = UserRepository() // было лень писать модуль

    fun loadUsersList(): Single<List<User>> =
            repository.loadUsersList()
}