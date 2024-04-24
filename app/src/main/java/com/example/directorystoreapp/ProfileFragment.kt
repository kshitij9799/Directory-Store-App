package com.example.directorystoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class ProfileFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        val editProfile = view.findViewById<LinearLayout>(R.id.edit_profile_layout)
        val editPhotos = view.findViewById<LinearLayout>(R.id.edit_photo_layout)
        val appLanguage = view.findViewById<LinearLayout>(R.id.app_language_layout)
        val logout = view.findViewById<LinearLayout>(R.id.logout_layout)

        editProfile.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragmentWithBottomNav(parentFragmentManager,EditProfileFragment())
        })

        editPhotos.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragmentWithBottomNav(parentFragmentManager,EditPhotoFragment())
        })

        logout.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragment(parentFragmentManager,SignInFragment())
        })

        return view
    }

}