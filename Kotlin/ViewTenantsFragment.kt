package com.example.tenantmanagementsystemgroupa

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tenantmanagementsystemgroupa.databinding.FragmentViewTenantsBinding

class ViewTenantsFragment : Fragment() {

    private var _binding: FragmentViewTenantsBinding? = null
    private val binding get() = _binding!!

    // Safe Args: the tenant that arrived with the action (or null)
    private val args: ViewTenantsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewTenantsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newTenant = args.newTenant

        // Data Binding: feeds <variable name="tenant"> in the layout
        binding.tenant = newTenant

        // Opened from the Dashboard or menu? Hide "Just added", call and share together
        if (newTenant == null) {
            binding.newTenantGroup.visibility = View.GONE
        }

        // Implicit Intent: open the dialer with the number filled in
        binding.callButton.setOnClickListener {
            if (newTenant != null) {
                try {
                    startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${newTenant.phone}")))
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(requireContext(), "No dialer found", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Implicit Intent: share the tenant's details with another app
        binding.shareButton.setOnClickListener {
            if (newTenant != null) {
                val share = Intent(Intent.ACTION_SEND)
                share.type = "text/plain"
                share.putExtra(Intent.EXTRA_TEXT, newTenant.summary())
                startActivity(Intent.createChooser(share, "Share tenant"))
            }
        }

        // Every saved tenant
        val tenants = TenantRepository.tenants
        binding.allTenantsTextView.text =
            if (tenants.isEmpty()) "No tenants yet. Add one from the Dashboard."
            else tenants.joinToString("\n\n") { it.summary() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
