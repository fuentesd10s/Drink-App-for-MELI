package com.fuentescreations.drinkappformeli.data.api

import com.fuentescreations.drinkappformeli.utils.AppConstans
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RetrofitInterface::class.java)
    }
}