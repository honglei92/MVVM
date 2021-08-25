package com.whl.mvvm.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.whl.mvvm.R
import com.whl.mvvm.databinding.ActivityMain2Binding
import com.whl.mvvm.github.model.User
import com.whl.mvvm.github.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {

    private var mUserViewModel: UserViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))
        initView()
    }

    private fun initView() {
        val activityMainBinding: ActivityMain2Binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main2)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel!!.getUser().observe(this, object : Observer<User> {
            override fun onChanged(user: User?) {
                if (user != null) {
                    activityMainBinding.userViewModel = mUserViewModel
                }
            }
        })
//        mUserViewModel!!.refresh()
    }
}