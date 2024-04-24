package com.example.directorystoreapp

import android.R.attr.bottom
import android.R.attr.left
import android.R.attr.right
import android.R.attr.top
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.marginBottom
import androidx.fragment.app.Fragment


class CreateUserFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_user, container, false)

        val addChildBtn = view.findViewById<ImageView>(R.id.add_child)

        addChildBtn.setOnClickListener(View.OnClickListener {
            addDynamicView(view)
        })

        return view
    }

    private fun addDynamicView(view: View) {
        val parentLayout: LinearLayout = view.findViewById(R.id.child_layout)
        val dynamicView: View = getLayoutInflater().inflate(R.layout.child_input_view, null)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, 30, 0, 0)
        dynamicView.layoutParams = params

        parentLayout.addView(dynamicView)
    }


}