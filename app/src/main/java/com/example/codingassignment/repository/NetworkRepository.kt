package com.example.codingassignment.repository

import com.example.codingassignment.dto.AddressResponse
import com.example.codingassignment.retrofit.GetDataService
import com.example.codingassignment.retrofit.RetrofitInstance
import retrofit2.Call


/**
 * Created by deepak.garg on 17/05/2020
 */

object NetworkRepository {

    fun getAddress(queryString : String,cityName : String) : Call<AddressResponse>{
        val service =
            RetrofitInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getAddress(queryString,cityName)
        return call
    }
}