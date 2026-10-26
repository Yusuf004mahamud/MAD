package com.example.tenantmanagementsystemgroupa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystemgroupa.databinding.FragmentAddTenantBinding

class AddTenantFragment : Fragment() {

    private var _binding: FragmentAddTenantBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTenantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val rent = binding.rentEditText.text.toString().trim()

            // Validation: error shown on the exact field that is wrong
            if (name.isEmpty()) {
                binding.tenantNameEditText.error = "Tenant name is required"
                return@setOnClickListener
            }
            if (phone.count { it.isDigit() } < 10) {
                binding.phoneEditText.error = "Enter a valid phone number"
                return@setOnClickListener
            }
            val rentAmount = rent.toDoubleOrNull()
            if (rentAmount == null || rentAmount <= 0) {
                binding.rentEditText.error = "Enter a rent amount"
                return@setOnClickListener
            }

            // Stop a double-tap from saving the same tenant twice
            binding.saveButton.isEnabled = false

            val tenant = Tenant(name, phone, rent)
            TenantRepository.addTenant(tenant)

            // Safe Args: generated from nav_graph.xml, REQUIRES a Tenant
            findNavController().navigate(
                AddTenantFragmentDirections.actionAddTenantFragmentToViewTenantsFragment(tenant)
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
