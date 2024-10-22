package com.prianka.nectar.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.search.SearchBar
import com.prianka.nectar.R
import com.prianka.nectar.data.Categories
import com.prianka.nectar.data.Groceries


class ExploreFragment : Fragment() {
    private lateinit var exploreRecView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exploreRecView = view.findViewById(R.id.explore_product_recView)

        //        Explore Products Recycler View layout setting
//        exploreRecView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        exploreRecView.setHasFixedSize(true)
        exploreRecView.layoutManager = GridLayoutManager(requireContext(), 2)
        exploreRecView.addItemDecoration(ItemSpacingDecoration(horizontal = 0, vertical = 4))
        exploreRecView.setPadding(8, 0, 0, 0)

        val exploreList = listOf(
            Categories(
                id = 1,
                categoryName = "Fresh Fruits Vegetable",
                quantity = 7,
                price = 4.99,
                imageUrl = "https://www.standard.co.uk/s3fs-public/thumbnails/image/2016/07/22/07/banana.jpg"
            ),
            Categories(
                id = 2,
                categoryName = "Red Apples",
                quantity = 10,
                price = 5.99,
                imageUrl = "https://www.standard.co.uk/s3fs-public/thumbnails/image/2016/07/22/07/banana.jpg"
            ),
            Categories(
                id = 3,
                categoryName = "Organic Bananas",
                quantity = 8,
                price = 8.99,
                imageUrl = ""
            ),
            Categories(
                id = 4,
                categoryName = "Organic Bananas",
                quantity = 9,
                price = 9.99,
                imageUrl = ""
            ),
            Categories(
                id = 5,
                categoryName = "Organic Bananas",
                quantity = 7,
                price = 4.99,
                imageUrl = ""
            ),
            Categories(
                id = 6,
                categoryName = "Organic Bananas",
                quantity = 7,
                price = 4.99,
                imageUrl = ""
            ),
            Categories(
                id = 7,
                categoryName = "Organic Bananas",
                quantity = 7,
                price = 4.99,
                imageUrl = ""
            ),
            Categories(
                id = 8,
                categoryName = "Organic Bananas",
                quantity = 7,
                price = 4.99,
                imageUrl = ""
            )
        )

        //    Setting Adapter in Exclusive offers Recycler view
        val exploreProductsAdapter =
            ExploreProductsAdapter(requireContext(), list = exploreList){ grocery ->
//                Pass the clicked Details to the Product Details Activity
                val intent = Intent(requireContext(), ProductDetailsActivity::class.java)
                intent.putExtra("grocery", grocery)
                startActivity(intent)
            }
        exploreRecView.adapter = exploreProductsAdapter

    }

}