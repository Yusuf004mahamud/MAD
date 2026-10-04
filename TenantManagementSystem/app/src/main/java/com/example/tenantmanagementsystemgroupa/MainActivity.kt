package com.example.tenantmanagementsystemgroupa

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystemgroupa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val rent = binding.rentEditText.text.toString().trim()

            var isValid = true

            if (name.isEmpty()) {
                binding.tenantNameEditText.error = "Tenant name is required"
                isValid = false
            }

            if (phone.isEmpty()) {
                binding.phoneEditText.error = "Phone number is required"
                isValid = false
            }

            if (rent.isEmpty()) {
                binding.rentEditText.error = "Rent amount is required"
                isValid = false
            }

            if (isValid) {
                val tenant = Tenant(name, phone, rent)
                binding.tenant = tenant
                binding.executePendingBindings()
                Toast.makeText(this, "Tenant details saved!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
