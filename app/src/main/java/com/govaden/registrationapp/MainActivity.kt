package com.govaden.registrationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.govaden.registrationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSignup.setOnClickListener {
            onPreviewClicked()
        }

        val spinnerTitlesValues: Array<String> = arrayOf("Mr.", "Mrs", "Ms")
        val spinnerTitlesAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerTitlesValues)
        binding.spinnerTitle.adapter = spinnerTitlesAdapter
    }
}

private fun onPreviewClicked() {


}