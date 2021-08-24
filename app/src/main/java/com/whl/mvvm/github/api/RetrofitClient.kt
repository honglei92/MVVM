package com.whl.mvvm.github.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    lateinit var retrofit: Retrofit

    companion object {
        private val BASE_URL: String = "https://github.com/"
        private var retrofitClient: RetrofitClient? = null

        fun getInstance(): RetrofitClient? {
            if (retrofitClient == null) {
                retrofitClient = RetrofitClient()
            }
            return retrofitClient
        }
    }

    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getApi(): Api {
        return retrofit.create(Api::class.java)
    }
}