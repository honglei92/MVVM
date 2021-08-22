package com.whl.mvvm.github.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.whl.mvvm.github.model.User
import com.whl.mvvm.github.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var user: LiveData<User>

    private lateinit var userRepository: UserRepository

    private var userName = "honglei92"

    init {

    }

}