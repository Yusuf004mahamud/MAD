package com.example.tenantmanagementsystemgroupa

import java.io.Serializable

// Serializable lets Safe Args send a whole Tenant between screens
data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) : Serializable {
    fun summary(): String = "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
}
