package com.jollypanda.gvent_databinding.presentation

import android.databinding.ObservableField
import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
open class BasePresenter<T : MvpView> : MvpPresenter<T>() {
    val screenState = ObservableField<SCREEN_STATE>(SCREEN_STATE.IS_LOADING)
}