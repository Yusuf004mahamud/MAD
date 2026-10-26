package com.example.tenantmanagementsystemgroupa

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystemgroupa.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Email sent back from RegisterActivity (null if the app opened normally)
        intent.getStringExtra("EMAIL")?.let { binding.emailEditText.setText(it) }

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString()

            // Validate: show the error on the field itself
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailEditText.error = "Enter a valid email"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.passwordEditText.error = "Enter your password"
                return@setOnClickListener
            }

            // Explicit Intent: open MainActivity and attach the email for the drawer header
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("EMAIL", email)
            startActivity(intent)
            finish()   // so Back from the app doesn't return to Login
        }

        binding.registerTextView.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Implicit Intent: ask any browser to open the website
        binding.helpTextView.setOnClickListener {
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.strathmore.edu")))
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No browser found on this device", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
