package com.whl.mvvm.github.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.whl.mvvm.github.api.Api
import com.whl.mvvm.github.db.UserDao
import com.whl.mvvm.github.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    private var TAG: String = this.javaClass.name
    private var userDao: UserDao? = null
    private lateinit var api: Api

    constructor(userDao: UserDao, api: Api) {
        this.userDao = userDao
        this.api = api
    }

    fun getUser(name: String): LiveData<User>? {
        refresh(name)
        return userDao?.getUserByName(name)
    }

    private fun refresh(name: String) {
        api.getUser(name).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.body() != null) {
                    insertUser(response.body()!!)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

            }
        })
    }

    private fun insertUser(body: User) {
        AsyncTask.execute { userDao?.insertData(body) }
    }
}