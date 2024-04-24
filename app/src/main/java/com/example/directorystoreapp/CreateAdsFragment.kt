package com.example.directorystoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class CreateAdsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_create_ads, container, false)
        val backBtn = view.findViewById<ImageView>(R.id.back_btn)


        backBtn.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragmentWithBottomNav(parentFragmentManager,HomeFragment())
        })
        return view
    }
}