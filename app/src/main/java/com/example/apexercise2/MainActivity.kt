package com.example.apexercise2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.apexercise2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.add.setOnClickListener {
            calculateResult("+")

        }

        binding.subtract.setOnClickListener {
            calculateResult("-")
        }

        binding.multiply.setOnClickListener {
            calculateResult("*")
        }

        binding.divide.setOnClickListener {
            calculateResult("/")
        }
    }

    private fun calculateResult(operator: String) {
        val number1 = binding.number1.text.toString().toDouble()
        val number2 = binding.number2.text.toString().toDouble()

        val result: Double = when (operator) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> number1 / number2
            else -> 0.0
        }

        val message = when (operator) {
            "+" -> "The sum is $"
            "-" -> "The difference is $"
            "*" -> "The product is $"
            "/" -> "The quotient is $"
            else -> ""
        }

        binding.Result.text = result.toString()
        val formattedResult = "$message%.2f".format(result)
        println(formattedResult)
    }
}