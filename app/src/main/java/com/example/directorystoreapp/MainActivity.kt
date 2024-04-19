package com.example.directorystoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

var fragmentContainerView:FragmentContainerView ?= null

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentContainerView = findViewById(R.id.fragmentContainerView)

    }

    companion object{
        fun switchFragment(fragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean = true) {
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, fragment)
            if (addToBackStack) {
                transaction.addToBackStack(null)
            }
            transaction.commit()
        }

    }
}