package com.example.codingassignment.dto

import com.google.gson.annotations.SerializedName



/**
 * Created by deepak.garg on 17/05/2020
 */

class AddressResponse(
    @field:SerializedName("requestId")
    var requestId: String?,
    @field:SerializedName("data")
    var data: AddressData?
)