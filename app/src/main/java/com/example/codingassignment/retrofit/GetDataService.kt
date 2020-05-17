package com.example.codingassignment.retrofit

import com.example.codingassignment.dto.AddressResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by deepak.garg on 16/05/2020
 */

interface GetDataService {

    @GET("/compassLocation/rest/address/autocomplete")
    fun getAddress(@Query("queryString") queryString: String, @Query("city") cityString: String): Call<AddressResponse>
}