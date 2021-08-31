package com.example.lisalabassessment.models


import com.google.gson.annotations.SerializedName

data class AddRequest(
    @SerializedName("number_one") var numberOne: Int,
    @SerializedName("number_two") var numberTwo:Int
)
