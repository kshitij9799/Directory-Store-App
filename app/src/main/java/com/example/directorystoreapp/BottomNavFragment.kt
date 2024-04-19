package com.example.directorystoreapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

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

        return view
    }
}