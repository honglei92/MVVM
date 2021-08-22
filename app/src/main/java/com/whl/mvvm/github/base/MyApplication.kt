package com.whl.mvvm.github.base

import android.app.Application
import com.whl.mvvm.github.api.Api
import com.whl.mvvm.github.api.RetrofitClient
import com.whl.mvvm.github.db.UserDatabase

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        userDatabase = UserDatabase.getInstance(this)
        api = RetrofitClient.getInstance()!!.getApi()
    }

    companion object {
        private var userDatabase: UserDatabase? = null
        private var api: Api? = null

        fun getApi(): Api? {
            return api
        }

        fun getUserDatabase(): UserDatabase? {
            return userDatabase
        }
    }
}