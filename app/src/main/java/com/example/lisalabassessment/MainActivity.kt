package com.example.lisalabassessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lisalabassessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        click()
    }
    fun click(){
        binding.btnAddition.setOnClickListener {
            var intent= Intent(baseContext, AddActivity::class.java)
        }
        binding.btnSubstraction.setOnClickListener {
            var intent= Intent(baseContext, SubstractActivity::class.java)
        }
    }
}