package com.example.architecturedemo.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.architecturedemo.R
import com.example.architecturedemo.coordinator.FeatureNavigator
import com.example.architecturedemo.coordinator.FeatureNavigatorImpl
import com.example.architecturedemo.navigation.MainCoordinator

class MainActivity: AppCompatActivity() {
    private val featureNavigator: FeatureNavigator = FeatureNavigatorImpl(this)
    val coordinator: MainCoordinator = MainCoordinator(featureNavigator)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // val binding =  ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val buttonPost = findViewById<Button>(R.id.button_post)
        val buttonUser = findViewById<Button>(R.id.button_user)
        buttonPost.setOnClickListener {
            Log.v("Yamiii","post")
            featureNavigator.post()
        }

        buttonUser.setOnClickListener {
            Log.v("Yamiii","Users")
            featureNavigator.users()
        }
    }
}