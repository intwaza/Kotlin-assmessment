package com.example.lisalabassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lisalabassessment.api.ApiClient
import com.example.lisalabassessment.api.ApiInterface
import com.example.lisalabassessment.databinding.ActivityDivideBinding
import com.example.lisalabassessment.models.DivideRequest
import com.example.lisalabassessment.models.DivideResponse
import com.example.lisalabassessment.models.MultiplyRequest
import com.example.lisalabassessment.models.MultiplyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DivideActivity : AppCompatActivity() {
    lateinit var binding: ActivityDivideBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDivideBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun getDivide() {
        binding.btnDivide.setOnClickListener {
            var num1 = binding.etDivNum1.text.toString().toInt()
            var num2 = binding.etDivNum2.text.toString().toInt()
            var dividerequest = DivideRequest(
                numberOne = num1,
                numberTwo = num2

            )
            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.divide(dividerequest)
            request.enqueue(object : Callback<DivideResponse?> {
                override fun onResponse(
                    call: Call<DivideResponse?>,
                    response: Response<DivideResponse?>
                ) {
                    if (response.isSuccessful) {
                        var result = num1 / num2
                        Toast.makeText(baseContext, result, Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(
                            baseContext,
                            response.errorBody()?.string(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<DivideResponse?>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}

