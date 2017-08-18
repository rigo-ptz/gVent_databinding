package com.jollypanda.gvent_databinding.ui.activity

import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.github.nitrico.lastadapter.LastAdapter
import com.github.nitrico.lastadapter.Type
import com.jollypanda.gvent_databinding.BR
import com.jollypanda.gvent_databinding.R
import com.jollypanda.gvent_databinding.data.remote.response.User
import com.jollypanda.gvent_databinding.databinding.ActivityMainBinding
import com.jollypanda.gvent_databinding.databinding.ItemUserBinding
import com.jollypanda.gvent_databinding.presentation.MainPresenter
import com.jollypanda.gvent_databinding.presentation.MainView
import com.jollypanda.gvent_databinding.presentation.SCREEN_STATE
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_content.*
import kotlinx.android.synthetic.main.view_error.*

/**
 * @author Yamushev Igor
 * @since  17.08.17
 */
class MainActivity : BaseActivity<ActivityMainBinding>(), MainView {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun getLayout() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.presenter = mainPresenter
        initToolbar()
        initLoadUsers()
        btnRetry.setOnClickListener { Toast.makeText(this, "Жоский хардкод here", Toast.LENGTH_SHORT).show() }
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "It's a Databinding!"
    }

    private fun initLoadUsers() {
        mainPresenter.loadUsers(this)
    }

    override fun showUsers(users: List<User>) {
        mainPresenter.screenState.set(SCREEN_STATE.CONTENT_SUCCESS)
        LastAdapter(users, BR.user)
                .map<User>(Type<ItemUserBinding>(R.layout.item_user)
                                     .onClick {
                                         Toast.makeText(this, "Тап по ${it.binding.user.name}", Toast.LENGTH_SHORT).show()
                                     })
                .into(rvUsers)
    }

    override fun showEmptyContent() {
        mainPresenter.screenState.set(SCREEN_STATE.CONTENT_IS_EMPTY)
    }

    override fun showError(msg: String?) {
        mainPresenter.screenState.set(SCREEN_STATE.ERROR)
    }

    override fun showInternetError() {
        mainPresenter.screenState.set(SCREEN_STATE.ERROR)
    }

}