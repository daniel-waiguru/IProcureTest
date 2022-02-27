package com.danielwaiguru.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.WindowInsetsControllerCompat
import com.danielwaiguru.presentation.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupStatusBar()
    }
    private fun setupStatusBar() {
        WindowInsetsControllerCompat(window, window.decorView.rootView)
            .isAppearanceLightStatusBars = true
    }
}