package com.example.myapplication.ui.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.R

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}