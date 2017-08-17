package com.jollypanda.gvent_databinding.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import com.jollypanda.gvent_databinding.App
import com.jollypanda.gvent_databinding.model.UserModel
import javax.inject.Inject

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
@InjectViewState
class MainPresenter : BasePresenter<MainView>() {

    @Inject
    lateinit var usersModel: UserModel

    init {
        App.appComponent.injectTo(this)
    }

    fun loadUsers() {

    }

}

interface MainView : MvpView {
    fun showUsers()
    fun showEmptyContent()
    fun showError()
}