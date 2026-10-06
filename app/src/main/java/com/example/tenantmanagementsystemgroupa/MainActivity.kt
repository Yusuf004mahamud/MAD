package com.example.tenantmanagementsystemgroupa

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystemgroupa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lastTenant: Tenant? = null

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
                lastTenant = tenant   // remember it so CALL knows whose number to dial
                Toast.makeText(this, "Tenant details saved!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.callButton.setOnClickListener {
            val tenant = lastTenant
            if (tenant == null || tenant.phone.isEmpty()) {
                Toast.makeText(this, "Save a tenant with a valid phone number first", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // ACTION_DIAL opens the dialer with the number filled in (no permission needed)
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${tenant.phone}"))
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "No dialer app available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
