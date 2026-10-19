package com.example.tenantmanagementsystemgroupa

// One shared list of tenants for the whole app
object TenantRepository {
    val tenants = mutableListOf<Tenant>()

    fun addTenant(tenant: Tenant) {
        tenants.add(tenant)
    }

    fun totalRent(): Double = tenants.sumOf { it.rent.toDoubleOrNull() ?: 0.0 }
}
