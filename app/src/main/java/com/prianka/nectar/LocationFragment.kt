package com.prianka.nectar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Spinner
import androidx.navigation.Navigation
import com.google.android.material.button.MaterialButton
import com.prianka.nectar.ui.auth.LoginActivity

class LocationFragment : Fragment() {
    private lateinit var submitLocation: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_location, container, false)

        // Traverse previous navigation
        view.findViewById<ImageView>(R.id.back_btn).setOnClickListener{

            Navigation.findNavController(view).navigate(R.id.action_locationFragment_to_verificationFragment)
        }

        return view
    }
    // Function to set up a spinner with a custom adapter
    private fun setupSpinner(spinner: Spinner, items: Array<String>) {
        val adapter = SpinnerAdapter(requireContext(), items)
        spinner.adapter = adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Find the spinners
        val spinnerZone = view.findViewById<Spinner>(R.id.zone_spinner)
        val spinnerAreas = view.findViewById<Spinner>(R.id.area_spinner)

        // Define the zone and area arrays
        val spinnerZones = arrayOf("Banasree", "Gulshan", "Banani", "Dhanmondi", "Mirpur", "Uttara", "Mohammadpur", "Bashundhara", "Motijheel", "Farmgate", "Khilkhet", "Malibagh")
        val areaZones = arrayOf("Block A", "Block B", "Block C", "Block D", "Block E", "Block F", "Block G", "Block H", "Block I", "Block J", "Block K", "Block L")

        // Set up the spinners with the custom adapter
        setupSpinner(spinnerZone, spinnerZones)
        setupSpinner(spinnerAreas, areaZones)


//        Location Submit Action
        submitLocation = view.findViewById(R.id.submit_location)
        submitLocation.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun  navigateToLogin(){
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
    }
}