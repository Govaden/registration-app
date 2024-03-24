package com.govaden.registrationapp

import android.content.Intent
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

        setupSpinner()

        binding.buttonSignup.setOnClickListener {
            setupButton()
        }
    }

    private fun setupSpinner() {
        val spinnerTitlesValues: Array<String> = arrayOf("Mr.", "Mrs.", "Ms.", "Dr.", "Prof.")
        val spinnerTitlesAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerTitlesValues)
        binding.spinnerTitle.adapter = spinnerTitlesAdapter
    }


    private fun setupButton() {

        val registrationUser = User(
            binding.spinnerTitle.selectedItem?.toString(),
            binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextEmail.text.toString(),
            binding.editTextPassword.text.toString(),
            binding.editTextPhoneNumber.text.toString()
        )

        val registrationActivityIntent = Intent(this, RegistrationActivity::class.java)
        registrationActivityIntent.putExtra("User", registrationUser)

        startActivity(registrationActivityIntent)
    }
}