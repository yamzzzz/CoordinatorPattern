package com.example.architecturedemo.coordinator

import android.os.Bundle
import androidx.annotation.IdRes

data class NavigationDestination(@IdRes val navId: Int, val navigationArguments: Bundle? = null)