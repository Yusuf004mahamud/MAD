package com.example.tenantmanagementsystemgroupa

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystemgroupa.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            val fullName = binding.fullNameEditText.text.toString().trim()
            val email = binding.registerEmailEditText.text.toString().trim()
            val password = binding.registerPasswordEditText.text.toString()

            var isValid = true

            if (fullName.isEmpty()) {
                binding.fullNameEditText.error = "Full name is required"
                isValid = false
            }

            if (email.isEmpty()) {
                binding.registerEmailEditText.error = "Email is required"
                isValid = false
            }

            if (password.isEmpty()) {
                binding.registerPasswordEditText.error = "Password is required"
                isValid = false
            }

            if (isValid) {
                Toast.makeText(this, "Account created. Please log in.", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("EMAIL", email)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }
        }

        binding.loginLinkTextView.setOnClickListener {
            finish()
        }
    }
}
