package com.prianka.nectar.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prianka.nectar.R
import com.prianka.nectar.data.Groceries

class ShopFragment : Fragment() {
    private lateinit var exclusiveRecView: RecyclerView
    private lateinit var bestSellingRecView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Recycler View findings
        exclusiveRecView = view.findViewById(R.id.exclusive_offers_recview)
        bestSellingRecView = view.findViewById(R.id.best_selling_recView)


//        Exclusive Offers Recycler View layout setting
        exclusiveRecView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        exclusiveRecView.setHasFixedSize(true)

//        Best Selling Recycler View layout setting
        bestSellingRecView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bestSellingRecView.setHasFixedSize(true)

        val exclusiveOfferList = listOf(
            Groceries(
                id = 1,
                groceryName = "Organic Bananas",
                quantity = 7,
                price = 4.99,
                imageUrl = "https://www.standard.co.uk/s3fs-public/thumbnails/image/2016/07/22/07/banana.jpg"
            ),
            Groceries(
                id = 2,
                groceryName = "Red Apples",
                quantity = 10,
                price = 5.99,
                imageUrl = "https://www.standard.co.uk/s3fs-public/thumbnails/image/2016/07/22/07/banana.jpg"
            ),
            Groceries(
                id = 3,
                groceryName = "Organic Bananas",
                quantity = 8,
                price = 8.99,
                imageUrl = ""
            ),
            Groceries(
                id = 4,
                groceryName = "Organic Bananas",
                quantity = 9,
                price = 9.99,
                imageUrl = ""
            ),
            Groceries(
                id = 5,
                groceryName = "Organic Bananas",
                quantity = 7,
                price = 4.99,
                imageUrl = ""
            ),
            Groceries(
                id = 6,
                groceryName = "Organic Bananas",
                quantity = 7,
                price = 4.99,
                imageUrl = ""
            ),
            Groceries(
                id = 7,
                groceryName = "Organic Bananas",
                quantity = 7,
                price = 4.99,
                imageUrl = ""
            ),
            Groceries(
                id = 8,
                groceryName = "Organic Bananas",
                quantity = 7,
                price = 4.99,
                imageUrl = ""
            )
        )

        //    Setting Adapter in Exclusive offers Recycler view
        val exclusiveOffersAdapter =
            ExclusiveOffersAdapter(requireContext(), list = exclusiveOfferList){ grocery ->
//                Pass the clicked Details to the Product Details Activity
                val intent = Intent(requireContext(), ProductDetailsActivity::class.java)
                intent.putExtra("grocery", grocery)
                startActivity(intent)
            }
        exclusiveRecView.adapter = exclusiveOffersAdapter

        //    Setting Adapter in Best Offers Recycler view
        val bestSellingAdapter = BestSellingAdapter(requireContext(), list = exclusiveOfferList)
        { grocery ->
            val intent = Intent(requireContext(), ProductDetailsActivity::class.java)
            intent.putExtra("grocery", grocery)
            startActivity(intent)
        }
        bestSellingRecView.adapter = bestSellingAdapter

    }
}


