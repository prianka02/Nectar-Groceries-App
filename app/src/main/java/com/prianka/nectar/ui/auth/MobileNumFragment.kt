package com.prianka.nectar.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.prianka.nectar.R

class MobileNumFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_mobile_num, container, false)


       // Add navigation in floating button to the verification fragment
        view.findViewById<ImageView>(R.id.floating_next).setOnClickListener{

                Navigation.findNavController(view).navigate(R.id.action_mobileNumFragment_to_verificationFragment)
            }

        // Traverse previous navigation
        view.findViewById<ImageView>(R.id.back_btn).setOnClickListener{

            Navigation.findNavController(view).navigate(R.id.action_mobileNumFragment_to_signInFragment)
        }

        return view
    }
}