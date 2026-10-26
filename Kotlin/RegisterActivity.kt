package com.example.tenantmanagementsystemgroupa

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
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

            if (fullName.isEmpty()) {
                binding.fullNameEditText.error = "Full name is required"
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.registerEmailEditText.error = "Enter a valid email"
                return@setOnClickListener
            }
            if (password.length < 6) {
                binding.registerPasswordEditText.error = "At least 6 characters"
                return@setOnClickListener
            }

            Toast.makeText(this, "Account created. Please log in.", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("EMAIL", email)                  // data travels with the Intent
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP    // reuse the Login already open
            startActivity(intent)
        }

        // Register was opened from Login, so closing it reveals Login again
        binding.loginLinkTextView.setOnClickListener { finish() }
    }
}
