package com.example.lisalabassessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.lisalabassessment.api.ApiClient
import com.example.lisalabassessment.api.ApiInterface
import com.example.lisalabassessment.databinding.ActivityMultiplyBinding
import com.example.lisalabassessment.models.MultiplyRequest
import com.example.lisalabassessment.models.MultiplyResponse
import com.example.lisalabassessment.models.SubstractRequest
import com.example.lisalabassessment.models.SubstractResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MultiplyActivity : AppCompatActivity() {
    lateinit var binding: ActivityMultiplyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMultiplyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getMultiply()
    }
    fun getMultiply(){
        binding.btnMultiply.setOnClickListener {
            var num1 = binding.etMultiplynum1.text.toString().toInt()
            var num2 = binding.etMultiplyNum2.text.toString().toInt()
            var multiplyrequest = MultiplyRequest(
                numberOne = num1,
                numberTwo = num2

            )
            val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.multiply(multiplyrequest)
            request.enqueue(object : Callback<MultiplyResponse?> {
                override fun onResponse(
                    call: Call<MultiplyResponse?>,
                    response: Response<MultiplyResponse?>
                ) {
                    if (response.isSuccessful) {
                        var result = num1 * num2
                        Toast.makeText(baseContext, result, Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(baseContext, response.errorBody()?.string(), Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<MultiplyResponse?>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }
            })
        }
    }
}



