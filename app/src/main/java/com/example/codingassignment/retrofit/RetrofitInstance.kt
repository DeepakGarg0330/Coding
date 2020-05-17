package com.example.codingassignment.retrofit

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


/**
 * Created by deepak.garg on 16/05/2020
 */

object RetrofitInstance {

    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://digi-api.airtel.in"

    val retrofitInstance: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
}