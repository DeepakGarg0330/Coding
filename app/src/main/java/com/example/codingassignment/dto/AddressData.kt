package com.example.codingassignment.dto

import com.google.gson.annotations.SerializedName

/**
 * Created by deepak.garg on 17/05/2020
 */

class AddressData(
    @field:SerializedName("autoCompleteRequestString")
    var autoCompleteRequestString: String?,
    @field:SerializedName("focusWord")
    var focusWord: String?,
    @field:SerializedName("addressList")
    var addressList: List<Address>?
    )