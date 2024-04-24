package com.example.directorystoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragmentContainerView:FragmentContainerView ?= null

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

        fun switchFragmentWithBottomNav(fragmentManager: FragmentManager, fragment: Fragment, addToBackStack: Boolean = true) {
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()

            transaction.replace(R.id.fragmentContainerView, BottomNavFragment())
            transaction.commit()

            val transaction1: FragmentTransaction = fragmentManager.beginTransaction()

            transaction1.replace(R.id.fragment_container_with_bottom_nav, fragment)
            if (addToBackStack) {
                transaction1.addToBackStack(null)
            }
            transaction1.commit()
        }

    }
}