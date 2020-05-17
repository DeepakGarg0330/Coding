package com.example.codingassignment.utils

/**
 * Created by deepak.garg on 17/05/2020
 */

object StringUtil{
    fun isNotBlank(string : String?) : Boolean{
        return string != null && !("".equals(string.trim()))
    }
}