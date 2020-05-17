package com.example.codingassignment.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.codingassignment.dto.AddressResponse
import com.example.codingassignment.repository.NetworkRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by deepak.garg on 16/05/2020
 */

class CitySearchViewModel : ViewModel() {

    var queryString: String = ""
    var cityName: String = ""
    var call: Call<AddressResponse>? = null
    var liveData: MutableLiveData<AddressResponse>
    var errorLiveData: MutableLiveData<Void>

    init {
        liveData = MutableLiveData()
        errorLiveData = MutableLiveData()
    }

    fun getAddress(queryString: String, cityName: String) {
        if (call != null && !call!!.isExecuted) {
            call!!.cancel()
        }
        call = NetworkRepository.getAddress(queryString, cityName)
        call!!.enqueue(object : Callback<AddressResponse> {
            override fun onResponse(call: Call<AddressResponse>, response: Response<AddressResponse>) {
                if (response.isSuccessful) {
                    liveData.value = response.body()
                } else {
                    liveData.value = null
                    errorLiveData.value = null
                }
            }

            override fun onFailure(call: Call<AddressResponse>, t: Throwable) {
                if(!call.isCanceled) {
                    liveData.value = null
                    errorLiveData.value = null
                }
            }
        })
    }
}