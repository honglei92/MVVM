package com.whl.mvvm.github.repository

import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.LiveData
import com.whl.mvvm.github.api.Api
import com.whl.mvvm.github.db.UserDao
import com.whl.mvvm.github.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(userDao: UserDao, private var api: Api) {
    private var TAG: String = this.javaClass.name
    private var userDao: UserDao? = userDao

    fun getUser(name: String): LiveData<User>? {
        refresh(name)
        return userDao?.getUserByName(name)
    }

    fun refresh(name: String) {
        Log.i("xxx", "get")
        api.getUser(name).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.body() != null) {
                    Log.i("xxx", response.message() + "")
                    insertUser(response.body()!!)
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.i("xxx", t.message + "")
            }
        })
    }

    private fun insertUser(body: User) {
        AsyncTask.execute { userDao?.insertData(body) }
    }
}