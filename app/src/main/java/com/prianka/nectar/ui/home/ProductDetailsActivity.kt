package com.prianka.nectar.ui.home

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.prianka.nectar.R

class ProductDetailsActivity : AppCompatActivity() {
    //    Collapsed item showing boolean
    private var isProductExpanded = false
    private var isNutritionExpanded = false
    private var isReviewExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_product_details)

        //        Collapsed Product Items findings
        val productDetailContainer = findViewById<RelativeLayout>(R.id.product_detail_container)
        val productDetailContent = findViewById<TextView>(R.id.product_detail_content)
        val productArrow = findViewById<ImageView>(R.id.product_arrow_icon)
//        Collapsed Nutrition Items findings
        val nutritionDetailContainer = findViewById<RelativeLayout>(R.id.nutrition_detail_container)
        val nutritionDetailContent = findViewById<TextView>(R.id.nutrition_detail_content)
        val nutritionArrow = findViewById<ImageView>(R.id.nutrition_arrow)
//        Collapsed Review Items findings
        val reviewDetailContainer = findViewById<RelativeLayout>(R.id.review_details_container)
        val reviewDetailContent = findViewById<TextView>(R.id.review_detail_content)
        val reviewArrow = findViewById<ImageView>(R.id.review_arrow)




        //        For Showing Collapsed Items in Product Details
        productDetailContainer.setOnClickListener {
            if (isProductExpanded) {
                // Collapse the content
                productDetailContent.visibility = View.GONE
                productArrow.setImageResource(R.drawable.arrow_right)
            } else {
                // Expand the content
                productDetailContent.visibility = View.VISIBLE
                productArrow.setImageResource(R.drawable.arrow_down)
            }
            isProductExpanded = !isProductExpanded
        }

        //        For Showing Collapsed Items in Nutrition Details
        nutritionDetailContainer.setOnClickListener {
            if (isNutritionExpanded) {
                // Collapse the content
                nutritionDetailContent.visibility = View.GONE
                nutritionArrow.setImageResource(R.drawable.arrow_right)
            } else {
                // Expand the content
                nutritionDetailContent.visibility = View.VISIBLE
                nutritionArrow.setImageResource(R.drawable.arrow_down)
            }
            isNutritionExpanded = !isNutritionExpanded
        }

        //        For Showing Collapsed Items in Review Details
        reviewDetailContainer.setOnClickListener {
            if (isReviewExpanded) {
                // Collapse the content
                reviewDetailContent.visibility = View.GONE
                reviewArrow.setImageResource(R.drawable.arrow_right)
            } else {
                // Expand the content
                reviewDetailContent.visibility = View.VISIBLE
                reviewArrow.setImageResource(R.drawable.arrow_down)
            }
            isReviewExpanded = !isReviewExpanded
        }
    }
}