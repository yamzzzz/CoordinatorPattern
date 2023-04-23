package com.example.architecturedemo.coordinator

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.fragment.app.add
import com.example.architecturedemo.R
import com.example.architecturedemo.ui.posts.PostMainActivity
import com.example.architecturedemo.ui.users.UsersMainActivity

class FeatureNavigatorImpl(private val context: Context): FeatureNavigator {
    override fun post() {
        Log.v("Yamiii","Post")
        context.startActivity(Intent(context, PostMainActivity::class.java))
    }

    override fun users() {
        Log.v("Yamiii","Users")
        context.startActivity(Intent(context, UsersMainActivity::class.java))
    }
}