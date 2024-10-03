package com.prianka.nectar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation


class SignInFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sign_in, container, false)

        view.findViewById<EditText>(R.id.mobile_edittext).setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                Navigation.findNavController(view).navigate(R.id.action_signInFragment_to_mobileNumFragment)
            }
        }

        return view
    }

}