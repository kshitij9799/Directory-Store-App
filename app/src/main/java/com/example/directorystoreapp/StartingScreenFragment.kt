package com.example.directorystoreapp

import android.annotation.SuppressLint
import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment


class StartingScreenFragment : Fragment() {

    private var loginBtn:TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_starting_screen, container, false)
        loginBtn = view.findViewById(R.id.login_btn)

        loginBtn?.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragment(
                parentFragmentManager,SignInFragment())
        })

        return view
    }
}