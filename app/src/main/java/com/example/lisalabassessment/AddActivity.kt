package com.example.lisalabassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lisalabassessment.api.ApiClient
import com.example.lisalabassessment.api.ApiInterface
import com.example.lisalabassessment.databinding.ActivityAddBinding
import com.example.lisalabassessment.models.AddRequest
import com.example.lisalabassessment.models.AddResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityAddBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        getAdd()
    }
    fun getAdd() {
        binding.btnAdd.setOnClickListener {
            var num1 = binding.etNum1.text.toString().toInt()
            var num2 = binding.etNum2.text.toString().toInt()
            var addrequest = AddRequest(
                numberOne = num1,
                numberTwo = num2

            )
            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.add(addrequest)
            request.enqueue(object : Callback<AddResponse> {
                override fun onResponse(call: Call<AddResponse>, response: Response<AddResponse>) {
                    if (response.isSuccessful) {
                        var result = num1 + num2
                        Toast.makeText(baseContext, result, Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(
                            baseContext,
                            response.errorBody()?.string(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<AddResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}