package com.example.lisalabassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.lisalabassessment.api.ApiClient
import com.example.lisalabassessment.api.ApiInterface
import com.example.lisalabassessment.databinding.ActivitySubstractBinding

import com.example.lisalabassessment.models.SubstractRequest
import com.example.lisalabassessment.models.SubstractResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubstractActivity : AppCompatActivity() {
    lateinit var binding: ActivitySubstractBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivitySubstractBinding.inflate(LayoutInflater.from())
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getSubstract()
    }
    fun getSubstract(){
        var num1= binding.etSubNum1.text.toString().toInt()
        var num2= binding.etSubNum2.text.toString().toInt()
        var substractrequest= SubstractRequest(
            numberOne = num1,
            numberTwo = num2

        )
        val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request= retrofit.substract(substractrequest)
        request.enqueue(object : Callback<SubstractResponse?> {
            override fun onResponse(
                call: Call<SubstractResponse?>,
                response: Response<SubstractResponse?>
            ) {
                if (response.isSuccessful){
                    var result= num1-num2
                    Toast.makeText(baseContext, result, Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<SubstractResponse?>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}