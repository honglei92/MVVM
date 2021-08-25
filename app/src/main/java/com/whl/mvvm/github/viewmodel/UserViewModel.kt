package com.whl.mvvm.github.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.whl.mvvm.github.base.MyApplication
import com.whl.mvvm.github.model.User
import com.whl.mvvm.github.repository.UserRepository

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var user: LiveData<User>

    private lateinit var userRepository: UserRepository

    private var userName = "honglei92"

    init {
        val database = MyApplication.getUserDatabase()
        val userDao = database!!.userDao()
        userRepository = UserRepository(userDao, MyApplication.getApi()!!)
        user = userRepository.getUser(userName)!!
    }

    fun getUser(): LiveData<User> {
        return user
    }

    fun refresh() {
        userRepository.refresh(userName)
    }

}