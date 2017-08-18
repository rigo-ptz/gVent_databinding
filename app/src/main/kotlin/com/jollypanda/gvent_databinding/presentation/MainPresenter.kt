package com.jollypanda.gvent_databinding.presentation

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import com.google.gson.JsonParseException
import com.jollypanda.gvent_databinding.App
import com.jollypanda.gvent_databinding.data.remote.response.User
import com.jollypanda.gvent_databinding.model.UserModel
import com.jollypanda.gvent_databinding.utils.extensions.defaultSubscribe
import com.jollypanda.gvent_databinding.utils.extensions.getDetailedInfo
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import java.io.IOException
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

    fun loadUsers(lifecycleProvider: LifecycleProvider<ActivityEvent>) {
        usersModel.loadUsersList()
                .bindUntilEvent(lifecycleProvider, ActivityEvent.STOP)
                .defaultSubscribe(onSuccess = this::onSuccessUsersLoad,
                                  onError = this::onErrorUsersLoad)
    }

    private fun onSuccessUsersLoad(users: List<User>) {
        if (users.isEmpty())
            viewState.showEmptyContent()
        else
            viewState.showUsers(users)
    }

    private fun onErrorUsersLoad(thr: Throwable) {
        when (thr) {
            is retrofit2.HttpException -> viewState.showError(thr.getDetailedInfo())
            is IOException -> viewState.showInternetError()
            is JsonParseException -> viewState.showError()
            is IllegalStateException -> viewState.showError()
            else -> viewState.showError()
        }
    }

}

interface MainView : MvpView {
    fun showUsers(users:List<User>)
    fun showEmptyContent()
    fun showError(msg: String? = null)
    fun showInternetError()
}