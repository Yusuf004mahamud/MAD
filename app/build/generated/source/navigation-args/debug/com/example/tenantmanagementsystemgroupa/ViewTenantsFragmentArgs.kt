package com.example.tenantmanagementsystemgroupa

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class ViewTenantsFragmentArgs(
  public val newTenant: Tenant? = null,
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(Tenant::class.java)) {
      result.putParcelable("newTenant", this.newTenant as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Tenant::class.java)) {
      result.putSerializable("newTenant", this.newTenant as Serializable?)
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Tenant::class.java)) {
      result.set("newTenant", this.newTenant as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Tenant::class.java)) {
      result.set("newTenant", this.newTenant as Serializable?)
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): ViewTenantsFragmentArgs {
      bundle.setClassLoader(ViewTenantsFragmentArgs::class.java.classLoader)
      val __newTenant : Tenant?
      if (bundle.containsKey("newTenant")) {
        if (Parcelable::class.java.isAssignableFrom(Tenant::class.java) ||
            Serializable::class.java.isAssignableFrom(Tenant::class.java)) {
          __newTenant = bundle.get("newTenant") as Tenant?
        } else {
          throw UnsupportedOperationException(Tenant::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __newTenant = null
      }
      return ViewTenantsFragmentArgs(__newTenant)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ViewTenantsFragmentArgs {
      val __newTenant : Tenant?
      if (savedStateHandle.contains("newTenant")) {
        if (Parcelable::class.java.isAssignableFrom(Tenant::class.java) ||
            Serializable::class.java.isAssignableFrom(Tenant::class.java)) {
          __newTenant = savedStateHandle.get<Tenant?>("newTenant")
        } else {
          throw UnsupportedOperationException(Tenant::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __newTenant = null
      }
      return ViewTenantsFragmentArgs(__newTenant)
    }
  }
}
