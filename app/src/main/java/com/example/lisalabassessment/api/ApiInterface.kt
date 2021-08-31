package com.example.lisalabassessment.api

import com.example.lisalabassessment.models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/calculator/add")
    fun add(@Body AddRequest:AddRequest): Call<AddResponse>
    @POST("/calculator/subtract")
    fun substract(@Body substractRequest: SubstractRequest): Call<SubstractResponse>
    @POST("/calculator/multiply")
    fun multiply(@Body multiplyRequest: MultiplyRequest): Call<MultiplyRequest>

}