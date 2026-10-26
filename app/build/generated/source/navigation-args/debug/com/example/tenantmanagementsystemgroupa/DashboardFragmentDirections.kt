package com.example.tenantmanagementsystemgroupa

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import java.io.Serializable
import kotlin.Int
import kotlin.Suppress

public class DashboardFragmentDirections private constructor() {
  private data class ActionDashboardFragmentToViewTenantsFragment(
    public val newTenant: Tenant? = null,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_dashboardFragment_to_viewTenantsFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Tenant::class.java)) {
          result.putParcelable("newTenant", this.newTenant as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(Tenant::class.java)) {
          result.putSerializable("newTenant", this.newTenant as Serializable?)
        }
        return result
      }
  }

  public companion object {
    public fun actionDashboardFragmentToAddTenantFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_addTenantFragment)

    public fun actionDashboardFragmentToViewTenantsFragment(newTenant: Tenant? = null):
        NavDirections = ActionDashboardFragmentToViewTenantsFragment(newTenant)
  }
}
