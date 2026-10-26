package com.example.tenantmanagementsystemgroupa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tenantmanagementsystemgroupa.databinding.ActivityMainBinding
import com.example.tenantmanagementsystemgroupa.databinding.NavHeaderBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "MainActivity: onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Our Toolbar becomes the App Bar
        setSupportActionBar(binding.toolbar)

        // 2. The NavController drives the NavHost
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // 3. Top-level screens show the hamburger icon; the drawer is passed in
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.dashboardFragment, R.id.addTenantFragment, R.id.viewTenantsFragment),
            binding.drawerLayout
        )

        // 4. Connect App Bar + drawer to the nav graph
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)

        // 5. Show the logged-in email in the drawer header
        val email = intent.getStringExtra("EMAIL")
        val headerBinding = NavHeaderBinding.bind(binding.navView.getHeaderView(0))
        headerBinding.headerEmailTextView.text = email ?: "Signed in"

        // 6. Improvement: Back closes an open drawer instead of leaving the screen
        val closeDrawerOnBack = object : OnBackPressedCallback(false) {
            override fun handleOnBackPressed() {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
        onBackPressedDispatcher.addCallback(this, closeDrawerOnBack)
        binding.drawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            override fun onDrawerOpened(drawerView: View) { closeDrawerOnBack.isEnabled = true }
            override fun onDrawerClosed(drawerView: View) { closeDrawerOnBack.isEnabled = false }
        })
    }

    // Hamburger opens the drawer; arrow goes back
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // Turn main_menu.xml into the three-dot menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            val intent = Intent(this, LoginActivity::class.java)
            // Clear every open screen so Back after logout can't reach the Dashboard
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            return true
        }
        // Menu ID matches a destination ID -> NavigationUI navigates for us
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    // ---- Lifecycle logs (Logcat filter: tag:TENANT_LIFECYCLE) ----
    override fun onStart() { super.onStart(); Log.d("TENANT_LIFECYCLE", "MainActivity: onStart") }
    override fun onResume() { super.onResume(); Log.d("TENANT_LIFECYCLE", "MainActivity: onResume") }
    override fun onPause() { super.onPause(); Log.d("TENANT_LIFECYCLE", "MainActivity: onPause") }
    override fun onStop() { super.onStop(); Log.d("TENANT_LIFECYCLE", "MainActivity: onStop") }
    override fun onRestart() { super.onRestart(); Log.d("TENANT_LIFECYCLE", "MainActivity: onRestart") }
    override fun onDestroy() { super.onDestroy(); Log.d("TENANT_LIFECYCLE", "MainActivity: onDestroy") }
}
