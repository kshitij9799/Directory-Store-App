package com.example.directorystoreapp

import android.content.Context
import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView

class BottomNavFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_nav, container, false)

        val home = view.findViewById<ImageView>(R.id.home)
        val explore = view.findViewById<ImageView>(R.id.explore)
        val addAd = view.findViewById<ImageView>(R.id.add_ad)
        val profile = view.findViewById<ImageView>(R.id.profile)
        val fragmentContainerWithBottomNav = view.findViewById<FragmentContainerView>(R.id.fragment_container_with_bottom_nav)
        val floatingAddButton = view.findViewById<ImageView>(R.id.floating_add_button)

        floatingAddButton?.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragment(parentFragmentManager,CreateUserFragment())
        })

        home?.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragmentWithBottomNav(parentFragmentManager,HomeFragment())
        })

        explore?.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragmentWithBottomNav(parentFragmentManager,ExploreFragment())
        })

        addAd?.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragmentWithBottomNav(parentFragmentManager,CreateAdsFragment())
        })

        profile?.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragmentWithBottomNav(parentFragmentManager,ProfileFragment())
        })

        return view
    }
}