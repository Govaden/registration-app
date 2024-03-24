package com.govaden.registrationapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.govaden.registrationapp.databinding.ActivityPreviewBinding

class RegistrationActivity : AppCompatActivity() {

    lateinit var user: User

    private lateinit var binding: ActivityPreviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getUser()
        displayUser()
        setupClickListeners()
    }

    private fun getUser() {
        user = intent.getSerializableExtra("User") as User
    }

    private fun displayUser() {
        binding.textViewPreviewUsername.text = user.getFullName()
        binding.textViewPreviewEmail.text = user.userEmail
        binding.textViewPreviewPhoneNumber.text = user.userPhoneNumber
    }


    private fun setupClickListeners() {
        binding.textViewPreviewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${user.userEmail}")
            }
            startActivity(intent)
        }

        binding.textViewPreviewPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${user.userPhoneNumber}")
            }
            startActivity(intent)
        }
    }
}