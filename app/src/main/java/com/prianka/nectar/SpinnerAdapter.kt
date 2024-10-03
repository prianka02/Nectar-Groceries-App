package com.prianka.nectar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SpinnerAdapter(context: Context, private val zones: Array<String>) :
    ArrayAdapter<String>(context, R.layout.spinner_selected_item, zones) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate the spinner_selected_item for the selected view
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.spinner_selected_item, parent, false)

        val textView = view.findViewById<TextView>(R.id.spinnerText)
        textView.text = zones[position]

        return view
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Inflate spinner_item for dropdown items
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.spinner_item, parent, false)

        // Ensure you are referencing the correct TextView ID here
        val textView = view.findViewById<TextView>(R.id.text1)
        textView.text = zones[position]

        return view
    }
}

