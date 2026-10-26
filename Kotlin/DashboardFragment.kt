package com.example.tenantmanagementsystemgroupa

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tenantmanagementsystemgroupa.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    // The Fragment OBJECT is created (no view yet)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onCreate")
    }

    // Build the VIEW from fragment_dashboard.xml
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onCreateView")
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    // The view exists: metrics are recalculated every time we come back here
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onViewCreated")

        val tenantCount = TenantRepository.tenants.size
        val totalRent = TenantRepository.totalRent()
        binding.tenantCountTextView.text = "Tenants\n$tenantCount"
        binding.totalRentTextView.text = "Total rent\nKSh %,.0f".format(totalRent)

        binding.addTenantButton.setOnClickListener {
            findNavController().navigate(
                DashboardFragmentDirections.actionDashboardFragmentToAddTenantFragment()
            )
        }
        binding.viewTenantsButton.setOnClickListener {
            findNavController().navigate(
                DashboardFragmentDirections.actionDashboardFragmentToViewTenantsFragment()
            )
        }
    }

    override fun onStart() { super.onStart(); Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onStart") }
    override fun onResume() { super.onResume(); Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onResume") }
    override fun onPause() { super.onPause(); Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onPause") }
    override fun onStop() { super.onStop(); Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onStop") }

    // The VIEW is destroyed; clear the binding so the old view can be freed
    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onDestroyView")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TENANT_LIFECYCLE", "   DashboardFragment: onDestroy")
    }
}
