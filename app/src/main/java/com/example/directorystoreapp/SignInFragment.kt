package com.example.directorystoreapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView

class SignInFragment : Fragment() {

    private var phoneNoEdittext: EditText?= null
    private var passwordEdittext: EditText?= null
    private var signInBtn: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        phoneNoEdittext = view.findViewById(R.id.phone_edit_text)
        passwordEdittext = view.findViewById(R.id.password_edit_text)
        signInBtn = view.findViewById(R.id.sign_in_btn)

        signInBtn?.setOnClickListener(View.OnClickListener {
            MainActivity.switchFragment(parentFragmentManager,BottomNavFragment())
        })

        return view
    }

}