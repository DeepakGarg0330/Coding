package com.example.codingassignment.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by deepak.garg on 17/05/2020
 */

class Address(
    @field:SerializedName("id")
    var id: String?,
    @field:SerializedName("city")
    var city: String?,
    @field:SerializedName("addressString")
    var addressString: String?,
    @field:SerializedName("latitude")
    var latitude: String?,
    @field:SerializedName("longitude")
    var longitude: String?,
    @field:SerializedName("label")
    var label: String?
)