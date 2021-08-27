package com.whl.mvvm.github.api

import com.whl.mvvm.github.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: String): Call<User>
}